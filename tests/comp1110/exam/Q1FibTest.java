package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1FibTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(4000);

    @Test
    public void testZero() {
        int r = Q1Fib.fib(0);
        assertTrue("Expected 0 but got "+r, r == 0);
    }

    @Test
    public void testOne() {
        int r = Q1Fib.fib(1);
        assertTrue("Expected 1 but got "+r, r == 1);
    }

    @Test
    public void testFive() {
        int r = Q1Fib.fib(5);
        assertTrue("Expected 5 but got " + r, r == 5);
    }

    @Test
    public void testRandomA(){
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int k = rand.nextInt(q.length);
            int n = q[k];
            int r = Q1Fib.fib(n);
            assertTrue("Expected "+z[k]+"but got " + r, r == z[k]);
        }
    }

    @Test
    public void testRandomB(){
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int k = rand.nextInt(q.length);
            int n = q[k];
            int r = Q1Fib.fib(n);
            assertTrue("Expected "+z[k]+"but got " + r, r == z[k]);
        }
    }

    int[] q = {24,17,15,2,27,32,18,20,33,13,24,11,38,12,16,22,30,9,27,19,26,4,31,25,16,10,10,25,29,0,16,6,26,3,0,3,33,19,17,3,26,6,13,12,6,8,39,5,31,32,30,38,34,38,30,39,26,17,31,25,10,21,12,32,7,33,19,34,0,23,36,25,11,12,39,36,5,31,6,28,21,14,29,10,5,36,26,22,30,39,12,10,32,6,4,12,19,24,2,19};
    int[] z = {46368,1597,610,1,196418,2178309,2584,6765,3524578,233,46368,89,39088169,144,987,17711,832040,34,196418,4181,121393,3,1346269,75025,987,55,55,75025,514229,0,987,8,121393,2,0,2,3524578,4181,1597,2,121393,8,233,144,8,21,63245986,5,1346269,2178309,832040,39088169,5702887,39088169,832040,63245986,121393,1597,1346269,75025,55,10946,144,2178309,13,3524578,4181,5702887,0,28657,14930352,75025,89,144,63245986,14930352,5,1346269,8,317811,10946,377,514229,55,5,14930352,121393,17711,832040,63245986,144,55,2178309,8,3,144,4181,46368,1,4181};

}
