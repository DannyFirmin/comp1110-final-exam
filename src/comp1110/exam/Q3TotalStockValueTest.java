package comp1110.exam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

/**
 * COMP1110 Final Exam, Question 3ii
 */
public class Q3TotalStockValueTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);
    @Test
    public void testTotalStock() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3);
        sm.newItem("1111", "Coffee", 4);

        sm.setTargetStock("1234", 90);
        sm.setTargetStock("1111", 10);
        sm.setActualStock("1111", 6);
        sm.setActualStock("1234", 50);
        assertTrue("Wrong!Expected 174.0 but got "+sm.totalStockValue(), sm.totalStockValue()==174.0);
    }

    // FIXME add one ore more JUnit unit tests that test the totalStockValue() method of the Q3SimpleStockManager class.

}
