package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1EvenTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    @Test
    public void TestTwo() {
        int n = 2;
        int[] a = {2};
        test(n, a);
    }

    @Test
    public void TestOne() {
        int n = 1;
        int[] a = {};
        test(n, a);
    }

    @Test
    public void TestTen() {
        int n = 10;
        int[] a = {2,4,6,8,10};
        test(n, a);
    }

    @Test
    public void TestFortyTwo() {
        int n = 42;
        int[] a = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42};
        test(n, a);
    }

    @Test
    public void TestFortyThree() {
        int n = 42;
        int[] a = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42};
        test(n, a);
    }

    private void test(int n, int[] a) {
        int[] r = Q1Even.even(n);
        String rs = "";
        for (int i = 0; i < r.length; i++) {
            rs += ((i!= 0) ? ", ": "")+r[i];
        }
        String as = "";
        for (int i = 0; i < a.length; i++) {
            as += ((i!= 0) ? ", ": "")+a[i];
        }

        if (a.length != r.length)
            assertTrue("Expected '{"+as+"}' but got '{"+rs+"}'", false);
        else {
            boolean match = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != r[i]) match = false;
            }
            assertTrue("Expected '{"+as+"}' but got '{"+rs+"}'", match);
        }
    }
}
