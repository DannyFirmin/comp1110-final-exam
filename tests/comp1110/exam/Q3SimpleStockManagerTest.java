package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3SimpleStockManagerTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(4000);

    @Test
    public void testAddGetOne() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        String name = sm.getItemName("1234");
        assertTrue("Expected 'Jam', but got '"+name, name.equals("Jam"));
        double price = sm.getItemPrice("1234");
        assertTrue("Expected 3.25, but got '"+price, price==3.25);
    }

    @Test
    public void testAddGetTwo() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.newItem("5678", "Coffee", 4.37);

        String name = sm.getItemName("5678");
        assertTrue("Expected 'Coffee', but got '"+name, name.equals("Coffee"));
        double price = sm.getItemPrice("5678");
        assertTrue("Expected 4.37, but got "+price, price==4.37);
    }

    @Test
    public void testAddGetThree() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.newItem("5678", "Coffee", 4.37);
        sm.newItem("ABCD", "Eggs", 3.98);


        String name = sm.getItemName("5678");
        assertTrue("Expected 'Coffee', but got '"+name, name.equals("Coffee"));
        double price = sm.getItemPrice("5678");
        assertTrue("Expected 4.37, but got "+price, price==4.37);
        price = sm.getItemPrice("ABCD");
        assertTrue("Expected 3.98, but got "+price, price==3.98);
    }

    @Test
    public void testSaleGetStock() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);

        sm.sale("1234",4);
        sm.sale("1234",2);
        int stock = sm.getStock("1234");
        assertTrue("Expected 94, but got "+stock, stock == 94);
    }

    @Test
    public void testSaleGetStockTwo() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.newItem("5678", "Coffee", 4.37);
        sm.addStock("5678", 37);

        sm.sale("1234",4);
        sm.sale("1234",2);
        sm.sale("5678",20);
        int stock = sm.getStock("1234");
        assertTrue("Expected 94, but got "+stock, stock == 94);
        stock = sm.getStock("5678");
        assertTrue("Expected 17, but got "+stock, stock == 17);
    }
    @Test
    public void testSaleGetStockThree() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.newItem("5678", "Coffee", 4.37);
        sm.addStock("5678", 37);

        sm.sale("1234",4);
        sm.addStock("1234", 7);
        sm.sale("1234",2);
        sm.sale("5678",20);
        sm.addStock("5678", 10);
        int stock = sm.getStock("1234");
        assertTrue("Expected 101, but got "+stock, stock == 101);
        stock = sm.getStock("5678");
        assertTrue("Expected 27, but got "+stock, stock == 27);
    }

    @Test
    public void testTargetStock() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.setTargetStock("1234", 90);
        sm.sale("1234",14);
        int required = sm.getStockRequired("1234");
        assertTrue("Expected 4, but got "+required, required == 4);
    }

    @Test
    public void testTargetStockTwo() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.newItem("5678", "Coffee", 4.37);
        sm.addStock("5678", 37);
        sm.addStock("1234", 100);
        sm.setTargetStock("1234", 90);
        sm.setTargetStock("5678", 40);
        sm.sale("1234",14);
        int required = sm.getStockRequired("1234");
        assertTrue("Expected 4, but got "+required, required == 4);
        required = sm.getStockRequired("5678");
        assertTrue("Expected 3, but got "+required, required == 3);
    }

    @Test
    public void testActualStock() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.setTargetStock("1234", 90);
        sm.sale("1234",14);
        int loss = sm.setActualStock("1234", 50);
        assertTrue("Expected difference of -36, but got "+loss, loss == -36);
    }

    @Test
    public void testActualStockTwo() {
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.setTargetStock("1234", 90);
        sm.sale("1234",14);
        sm.setActualStock("1234", 50);
        sm.setTargetStock("1234", 40);
        sm.sale("1234",14);
        int required = sm.getStockRequired("1234");
        assertTrue("Expected 4, but got "+required, required == 4);
    }
}
