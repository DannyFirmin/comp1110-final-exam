package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1ii
 */
public class Q1Fib {
    /**
     * This function takes a positive integer, n, and returns the corresponding Fibonacci
     * number, fib(N), where
     * fib(0) = 0,
     * fib(1) = 1, and
     * fib(N) = fib(N-1) + fib(N-2) for all N > 1.
     * <p>
     * for example:
     * if n = 1 the result will be 1, and
     * if n = 3 the result will be 2 because 2 = 1 + 1, and
     * if n = 5 the result will be 5 because 5 = 3 + 2
     */
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}