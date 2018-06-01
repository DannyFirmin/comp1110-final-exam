package comp1110.exam;


/**
 * COMP1110 Final Exam, Question 1i
 */
public class Q1Even {
    /**
     * This function takes a positive integer, n,  and returns an array
     * of ints containing all even integers between 1 and n, inclusive of n.
     * <p>
     * for example:
     * n = 5
     * the result will be
     * {2, 4}
     */
    public static int[] even(int n) {
        int[] d = new int[2];
        for (int i = 0; i <= n-1; i = i + 1) {
            for (int j = 2; j <= i; j = j + 2) {
                d[i] = j;
            }
        }
        return d;
    }
}
