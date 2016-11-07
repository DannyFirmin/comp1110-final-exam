package comp1110.exam;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.Map;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Q3StockManagerTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(4000);

    @Test
    public void testAddGetOne() {
        Q3StockManager sm = new Q3StockManager();
        sm.newVendor("A035", "ACME Corp");
        sm.newItem("1234", "A035", "Jam", 3.25);
        String name = sm.getItemVendorName("1234");
        assertTrue("Expected 'ACME Corp', but got '"+name, name.equals("ACME Corp"));
        double price = sm.getItemPrice("1234");
        assertTrue("Expected 3.25, but got '"+price, price==3.25);
    }

    @Test
    public void testAddGetTwo() {
        Q3StockManager sm = new Q3StockManager();
        sm.newVendor("A035", "ACME Corp");
        sm.newVendor("K033", "XYZ Pty Ltd");
        sm.newItem("1234", "A035", "Jam", 3.25);
        sm.newItem("5678", "K033", "Coffee", 4.37);

        String name = sm.getItemVendorName("5678");
        assertTrue("Expected 'XYZ Pty Ltd', but got '"+name, name.equals("XYZ Pty Ltd"));
        double price = sm.getItemPrice("5678");
        assertTrue("Expected 4.37, but got "+price, price==4.37);
    }

    @Test
    public void testAddGetThree() {
        Q3StockManager sm = new Q3StockManager();
        sm.newVendor("A035", "ACME Corp");
        sm.newVendor("K033", "XYZ Pty Ltd");
        sm.newItem("1234", "A035", "Jam", 3.25);
        sm.newItem("5678", "K033", "Coffee", 4.37);
        sm.newItem("5345", "K033", "Chocolate", 5.99);

        String name = sm.getItemVendorName("5678");
        assertTrue("Expected 'XYZ Pty Ltd', but got '"+name, name.equals("XYZ Pty Ltd"));
        double price = sm.getItemPrice("5678");
        assertTrue("Expected 4.37, but got "+price, price==4.37);
    }

    @Test
    public void testAddGetFour() {
        Q3StockManager sm = new Q3StockManager();
        sm.newVendor("A035", "ACME Corp");
        sm.newVendor("K033", "XYZ Pty Ltd");
        sm.newVendor("J123", "Foo Corp");
        sm.newVendor("F678", "Bar Pty Ltd");
        sm.newItem("1234", "A035", "Jam", 3.25);
        sm.newItem("5678", "K033", "Coffee", 4.37);
        sm.newItem("ABCD", "J123", "Eggs", 3.98);
        sm.newItem("5345", "F678", "Chocolate", 5.99);

        String name = sm.getItemVendorName("5678");
        assertTrue("Expected 'XYZ Pty Ltd', but got '"+name, name.equals("XYZ Pty Ltd"));
        name = sm.getItemVendorName("5345");
        assertTrue("Expected 'Bar Pty Ltd', but got '"+name, name.equals("Bar Pty Ltd"));
        double price = sm.getItemPrice("5678");
        assertTrue("Expected 4.37, but got "+price, price==4.37);
        price = sm.getItemPrice("ABCD");
        assertTrue("Expected 3.98, but got "+price, price==3.98);
    }

    @Test
    public void testSaleGetStock() {
        Q3StockManager sm = new Q3StockManager();
        sm.newVendor("A035", "ACME Corp");
        sm.newVendor("K033", "XYZ Pty Ltd");
        sm.newItem("1234", "A035", "Jam", 3.25);
        sm.addStock("1234", 100);
        sm.newItem("5678", "K033", "Coffee", 4.37);
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

    private void setupItem(Q3StockManager sm, String sku, String vid, String name, double price, int targetStock, int stock, int sale) {
        sm.newItem(sku, vid, name, price);
        sm.setTargetStock(sku, targetStock);
        sm.addStock(sku, stock);
        sm.sale(sku, sale);
    }

    private void setupStore(Q3StockManager sm) {
        sm.newVendor("A035", "ACME Corp");
        setupItem(sm, "1234", "A035", "Jam",           3.25, 90, 100, 15);
        setupItem(sm, "1239", "A035", "Honey",         4.25, 40, 50, 11);
        setupItem(sm, "1238", "A035", "Peanut Butter", 3.20, 40, 50, 33);
        setupItem(sm, "1237", "A035", "Vegemite",      4.20, 50, 50, 2);

        sm.newVendor("K033", "XYZ Pty Ltd");
        setupItem(sm, "5649", "K033", "Coffee",        4.37, 50, 50, 30);
        setupItem(sm, "5679", "K033", "Tea",           2.37, 50, 50, 1);

        sm.newVendor("J123", "Foo Corp");
        setupItem(sm, "ABCD", "J123", "Eggs",           3.98, 150, 50, 20);
        setupItem(sm, "ABCF", "J123", "Fish",           8.98, 50, 30, 11);
        setupItem(sm, "ABCK", "J123", "Prawns",        11.98, 50, 50, 7);

        sm.newVendor("F678", "Bar Pty Ltd");
        setupItem(sm, "5345", "F678", "Chocolate",      5.99, 40, 50, 5);
        setupItem(sm, "5135", "F678", "Jelly Beans",    1.99, 50, 50, 11);
        setupItem(sm, "5762", "F678", "Peppermints",    1.49, 30, 50, 21);
        setupItem(sm, "5213", "F678", "Gummy Bears",    2.99, 30, 50, 17);

        sm.newVendor("HYT5", "Gorp Pty Ltd");
        setupItem(sm, "YU67", "HYT5", "Sausages",       8.99, 60, 50, 15);
        setupItem(sm, "YU31", "HYT5", "Steak",         15.99, 75, 50, 13);
        setupItem(sm, "YU44", "HYT5", "Chicken",       11.49, 30, 50, 27);
    }

    private void stockCheck(String sku, int expect, Map<String, Integer> got) {
        int req = got.get(sku);
        assertTrue("Expected "+expect+" but got "+req+" for sku "+sku, req == expect);
    }

    @Test
    public void testTargetStockA() {
        Q3StockManager sm = new Q3StockManager();
        setupStore(sm);

        Map<String, Integer> req = sm.getStockRequired("A035");
        stockCheck("1234", 5, req);
        stockCheck("1239", 1, req);
        stockCheck("1238", 23, req);
        stockCheck("1237", 2, req);
    }

    @Test
    public void testTargetStockB() {
        Q3StockManager sm = new Q3StockManager();
        setupStore(sm);

        Map<String, Integer> req = sm.getStockRequired("K033");
        stockCheck("5649", 30, req);
        stockCheck("5679", 1, req);
    }

    @Test
    public void testTargetStockC() {
        Q3StockManager sm = new Q3StockManager();
        setupStore(sm);

        Map<String, Integer> req = sm.getStockRequired("J123");
        stockCheck("ABCD", 120, req);
        stockCheck("ABCF", 31, req);
        stockCheck("ABCK", 7, req);
    }

    @Test
    public void testTargetStockD() {
        Q3StockManager sm = new Q3StockManager();
        setupStore(sm);

        Map<String, Integer> req = sm.getStockRequired("F678");
        stockCheck("5345", -5, req);
        stockCheck("5135", 11, req);
        stockCheck("5762", 1, req);
        stockCheck("5213", -3, req);
    }

    @Test
    public void testTargetStockE() {
        Q3StockManager sm = new Q3StockManager();
        setupStore(sm);

        Map<String, Integer> req = sm.getStockRequired("HYT5");
        stockCheck("YU67", 25, req);
        stockCheck("YU31", 38, req);
        stockCheck("YU44", 7, req);
    }
}
