package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q5HashTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);


    public static final int HASH_ITERATIONS = 1000;

    @Test
    public void testInRange() {
        Random r = new Random();
        for (int i = 0; i < HASH_ITERATIONS; i++) {
            int range = 1 + r.nextInt(100);
            int value = r.nextInt();
            int h = Q5Hash.hash(value, range);
            assertTrue("hash("+value+", "+range+") returned a value out of range: "+h, h >= 0 && h < range);
        }
    }

    @Test
    public void testDeterminisitic() {
        Random r = new Random();
        for (int i = 0; i < HASH_ITERATIONS; i++) {
            int range = 1 + r.nextInt(100);
            int value = r.nextInt();
            int h = Q5Hash.hash(value, range);
            for (int j = 0; j < 20; j++) {
                int h2 = Q5Hash.hash(value, range);
                assertTrue("hash("+value+", "+range+") returned two different values: "+h+", "+h2, h2 == h);
            }
        }
    }

    @Test
    public void testUniformA() {
        Random r = new Random();
        int range = 10;
        int[] count = new int[range];
        int expected = 0;
        for (int i = 0; i < 100*HASH_ITERATIONS; i++) {
            int value = r.nextInt();
            int h = Q5Hash.hash(value, range);
            assertTrue("hash("+value+", "+range+") returned a value out of range: "+h, h >= 0 && h < range);
            count[h]++;
            expected++;
        }
        expected /= range;
        for (int i = 0; i < range; i++) {
            assertTrue("hash returned an uneven distribution, index "+i+" received "+count[i]+", when expected "+expected, count[i] > expected * 0.01 && count[i] < 0.99*(expected * range));
        }
    }

    @Test
    public void testUniformB() {
        Random r = new Random();
        int range = 10;
        int[] count = new int[range];
        int expected = 0;
        for (int i = 0; i < 100*HASH_ITERATIONS; i++) {
            int value = r.nextInt();
            int h = Q5Hash.hash(value, range);
            assertTrue("hash("+value+", "+range+") returned a value out of range: "+h, h >= 0 && h < range);
            count[h]++;
            expected++;
        }
        expected /= range;
        for (int i = 0; i < range; i++) {
            assertTrue("hash returned an uneven distribution, index "+i+" received "+count[i]+", when expected "+expected, count[i] > expected * 0.01 && count[i] < 0.99*(expected * range));
        }
    }

    @Test
    public void testUniformC() {
        Random r = new Random();
        int range = 10;
        int[] count = new int[range];
        int expected = 0;
        for (int i = 0; i < 100*HASH_ITERATIONS; i++) {
            int value = r.nextInt();
            int h = Q5Hash.hash(value, range);
            assertTrue("hash("+value+", "+range+") returned a value out of range: "+h, h >= 0 && h < range);
            count[h]++;
            expected++;
        }
        expected /= range;
        for (int i = 0; i < range; i++) {
            assertTrue("hash returned an uneven distribution, index "+i+" received "+count[i]+", when expected "+expected, count[i] > expected * 0.01 && count[i] < 0.99*(expected * range));
        }
    }

}
