package comp1110.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * COMP1110 Final Exam, Question 3i
 */
public class Q3SimpleStockManager {
    Map<String, Good> store = new HashMap<>();
    Map<String, Integer> amount = new HashMap<>();
    Map<String, Integer> targets = new HashMap<>();

    private class Good {
        String name;
        double price;

        public Good(String name, double price) {
            this.name = name;
            this.price = price;
        }

    }
    /**
     * A new product has been introduced.
     *
     * @param sku   The product’s sku
     * @param name  The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String name, double price) {
        store.put(sku, new Good(name, price));
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {

        return store.get(sku).name;
    }

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        return store.get(sku).price;
    }

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        if (amount.get(sku) == null) {
            return 0;
        } else {
            return amount.get(sku);
        }
        // FIXME Question 3id: complete this function
    }

    /**
     * An product has been sold; reduce current stock accordingly.
     *
     * @param sku  The product’s sku
     * @param sold The quantity sold
     * @return The number of items of stock remaining after the sale
     */
    public int sale(String sku, int sold) {
        int value;
        if (amount.get(sku) == null) {
            value = 0;
        } else {
            value = amount.get(sku);
        }

        int result = value - sold;
        amount.put(sku, result);
        return result;
        // FIXME Question 3ie: complete this function
    }

    /**
     * New stock has arrived; increase current stock accordingly.
     *
     * @param sku   The product’s sku
     * @param added The quantity newly arrived
     */
    public void addStock(String sku, int added) {
        // FIXME Question 3if: complete this function
        int value;
        if (amount.get(sku) == null) {
            value = 0;
        } else {
            value = amount.get(sku);
        }
        amount.put(sku, value + added);
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku    The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        // FIXME Question 3ig: complete this function
        targets.put(sku, target);

    }

    /**
     * Stock has been carefully counted. Set current stock correctly.
     *
     * @param sku    The product’s sku
     * @param actual The quantity actually in the store
     * @return The stock loss or gain (new current – old current)
     */
    public int setActualStock(String sku, int actual) {
        int result;
        if (amount.get(sku) == null) {
            result = actual;
        } else {
            result = actual - amount.get(sku);
        }
        amount.put(sku, actual);
        return result;  // FIXME Question 3ih: complete this function    }
    }

    /**
     * Return the number of items required for a given product
     * in order to reach the target stock for that item (target - stock)
     *
     * @param sku The SKU of the item to be queried
     * @return The difference between target and actual stock for that item
     */
    public int getStockRequired(String sku) {
        return targets.get(sku) - amount.get(sku); // FIXME Question 3ii: complete this function
    }

    /**
     * @return the value of the currently held stock (the price of the
     * product multiplied by the number of items in stock, for all items).
     */
    public double totalStockValue() {
        double val = 0;
        for (String s : amount.keySet()) {
            Good g = store.get(s);
            val += amount.get(s) * g.price;
        }
        return val;
        // FIXME Question 3ij: complete this function
    }
}
