package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q4ArrayListAddTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    @Test
    public void testAddOneSize() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        int s = l.size();
        assertTrue("Incorrect size.   Expected 1, but got "+s, s == 1);
    }

    @Test
    public void testAddOneValue() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        String v = l.get(0);
        assertTrue("Incorrect value returned after adding.   Expected 'a', but got '"+v+"'", v.equals("a"));
    }

    @Test
    public void testAddTwoSize() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        int s = l.size();
        assertTrue("Incorrect size after adding.   Expected 2, but got "+s, s == 2);
    }

    @Test
    public void testAddTwoValue() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        String v = l.get(0);
        assertTrue("Incorrect value returned after adding.   Expected 'a', but got '"+v+"'", v.equals("a"));
        v = l.get(1);
        assertTrue("Incorrect value returned after adding.   Expected 'bb', but got '"+v+"'", v.equals("bb"));
    }

    @Test
    public void testAddThreeSize() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        int s = l.size();
        assertTrue("Incorrect size after adding.   Expected 3, but got "+s, s == 3);
    }

    @Test
    public void testAddThreeValue() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        String v = l.get(0);
        assertTrue("Incorrect value returned after adding.   Expected 'a', but got '"+v+"'", v.equals("a"));
        v = l.get(1);
        assertTrue("Incorrect value returned after adding.   Expected 'bb', but got '"+v+"'", v.equals("bb"));
        v = l.get(2);
        assertTrue("Incorrect value returned after adding.   Expected 'ccc', but got '"+v+"'", v.equals("ccc"));
    }

    @Test
    public void testAddRandom() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Q4ArrayList<Integer> l = new Q4ArrayList<>();
            int len = 50 + rand.nextInt(300);
            for (int j = 0; j < len; j++) {
                l.add(j);
            }
            for (int j = 0; j < len; j++) {
                int v = l.get(j);
                assertTrue("Incorrect value returned after adding.   Expected "+j+", but got '"+v+"'", v == j);
            }
        }
    }

    @Test
    public void testRemoveSimple() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        assertTrue("Incorrect size after adding one element", l.size() == 1);
        assertTrue("Incorrect toString returned after adding one element", l.toString().equals("a"));
        l.remove(0);
        int s = l.size();
        assertTrue("Incorrect size after removing only element, got "+s+", but expected 0", s == 0);
    }

    @Test
    public void testRemoveLast() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue("Incorrect size after adding three elements", l.size() == 3);
        assertTrue("Incorrect toString returned after adding three elements", l.toString().equals("a bb ccc"));
        l.remove(2);
        int s = l.size();
        assertTrue("Incorrect size after removing last element.  Got "+s+", but expected 2", l.size() == 2);
        String ts = l.toString();
        assertTrue("Incorrect toString returned after removing last element, got '"+ts+"' but expected 'a bb'", ts.equals("a bb"));
    }

    @Test
    public void testRemoveFirst() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue("Incorrect size after adding three elements", l.size() == 3);
        assertTrue("Incorrect toString returned after adding three elements", l.toString().equals("a bb ccc"));
        l.remove(0);
        int s = l.size();
        assertTrue("Incorrect size after removing first element.  Got "+s+", but expected 2", l.size() == 2);
        String ts = l.toString();
        assertTrue("Incorrect toString returned after removing first element, got '"+ts+"' but expected 'bb ccc'", ts.equals("bb ccc"));
    }

    @Test
    public void testRemoveMiddle() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        l.add("ff");
        l.add("g");
        assertTrue("Incorrect size after adding five elements", l.size() == 5);
        assertTrue("Incorrect toString returned after adding five elements", l.toString().equals("a bb ccc ff g"));
        l.remove(2);
        int s = l.size();
        assertTrue("Incorrect size after removing middle element.  Got "+s+", but expected 4", l.size() == 4);
        String ts = l.toString();
        assertTrue("Incorrect toString returned after removing middle element, got '"+ts+"' but expected 'a bb ff g'", ts.equals("a bb ff g"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegative() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOverflow() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.remove(1);
    }

    @Test
    public void testReverseTwo() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        assertTrue("Incorrect size after adding two elements", l.size() == 2);
        assertTrue("Incorrect toString returned after adding two elements", l.toString().equals("a bb"));
        l.reverse();
        assertTrue("Incorrect size after reversal", l.size() == 2);
        String r = l.toString();
        assertTrue("Incorrect toString returned after reversal, got '"+r+"', but expected 'bb a'", l.toString().equals("bb a"));
    }

    @Test
    public void testReverseThree() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue("Incorrect size after adding three elements", l.size() == 3);
        assertTrue("Incorrect toString returned after adding three elements", l.toString().equals("a bb ccc"));
        l.reverse();
        assertTrue("Incorrect size after reversal", l.size() == 3);
        String r = l.toString();
        assertTrue("Incorrect toString returned after reversal, got '"+r+"', but expected 'ccc bb a'", l.toString().equals("ccc bb a"));
    }

    @Test
    public void testReverseFour() {
        Q4ArrayList<String> l = new Q4ArrayList<>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        l.add("dddd");
        assertTrue("Incorrect size after adding three elements", l.size() == 4);
        assertTrue("Incorrect toString returned after adding four elements", l.toString().equals("a bb ccc dddd"));
        l.reverse();
        assertTrue("Incorrect size after reversal", l.size() == 4);
        String r = l.toString();
        assertTrue("Incorrect toString returned after reversal, got '"+r+"', but expected 'dddd ccc bb a'", l.toString().equals("dddd ccc bb a"));
    }

    @Test
    public void testReverseRandomA() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Q4ArrayList<Integer> l = new Q4ArrayList<>();
            int len = 50 + rand.nextInt(300);
            for (int j = 0; j < len; j++) {
                l.add(j);
            }
            l.reverse();
            for (int j = 0; j < len; j++) {
                int v = l.get(j);
                assertTrue("Incorrect value returned after adding.   Expected "+(len-j-1)+", but got '"+v+"'", v == (len-j-1));
            }
        }
    }

    @Test
    public void testReverseRandomB() {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            Q4ArrayList<Integer> l = new Q4ArrayList<>();
            int len = 100 + rand.nextInt(300);
            for (int j = 0; j < len; j++) {
                l.add(j);
            }
            l.reverse();
            for (int j = 0; j < len; j++) {
                int v = l.get(j);
                assertTrue("Incorrect value returned after adding.   Expected "+(len-j-1)+", but got '"+v+"'", v == (len-j-1));
            }
        }
    }

    @Test
    public void testReverseRandomC() {
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            Q4ArrayList<Integer> l = new Q4ArrayList<>();
            int len = 150 + rand.nextInt(300);
            for (int j = 0; j < len; j++) {
                l.add(j);
            }
            l.reverse();
            for (int j = 0; j < len; j++) {
                int v = l.get(j);
                assertTrue("Incorrect value returned after adding.   Expected "+(len-j-1)+", but got '"+v+"'", v == (len-j-1));
            }
        }
    }
}
