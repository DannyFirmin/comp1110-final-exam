package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q1TourTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(4000);


    @Test
    public void testEmpty() {
        Q1Tour board = new Q1Tour("");
        int r = board.tourVictims("C6");
        assertTrue("Expected 0 for empty board but got "+r, r == 0);
    }

    @Test
    public void testOne() {
        for (int i = 0; i < ONEC6.length; i++) {
            Q1Tour board = new Q1Tour(ONEC6[i]);
            int r = board.tourVictims("C6");
            assertTrue("Expected 1 for '" + ONEC6[i] + "' board but got " + r, r == 1);
        }
    }

    @Test
    public void testOneNoisy() {
        for (int i = 0; i < ONEC6N.length; i++) {
            Q1Tour board = new Q1Tour(ONEC6N[i]);
            int r = board.tourVictims("C6");
            assertTrue("Expected 1 for '" + ONEC6N[i] + "' board but got " + r, r == 1);
        }
    }

    @Test
    public void testOneBlocked() {
        for (int i = 0; i < ONEC6B.length; i++) {
            Q1Tour board = new Q1Tour(ONEC6B[i]);
            int r = board.tourVictims("C6");
            assertTrue("Expected 1 for '" + ONEC6B[i] + "' board but got " + r, r == 1);
        }
    }

    @Test
    public void testTwoOneBlocked() {
        for (int i = 0; i < ONEC6TB.length; i++) {
            Q1Tour board = new Q1Tour(ONEC6TB[i]);
            int r = board.tourVictims("C6");
            assertTrue("Expected 2 for '" + ONEC6TB[i] + "' board but got " + r, r == 2);
        }
    }

    final static String[] ONEC6 = {"WA7", "WH1", "WD1", "WB4"};
    final static String[] ONEC6N = {"WA7BE7", "WH1BG2", "WD1BB3", "WB4BC7"};
    final static String[] ONEC6B = {"WA7WH1BE7BG3BF2", "WH1WA3BG2BB1BC2BC4BB5", "WD1WA8BB3BB6BC7", "WB4WH6BC7BG8BF7BF5BG4"};
    final static String[] ONEC6TB = {"WA7WH1BE7BG3BF2WB2", "WH1WA3BG2BB1BC2BC4BB5WA7", "WD1WA8BB3BB6BC7WH3", "WB4WH6BC7BG8BF7BF5BG4WE5"};


}
