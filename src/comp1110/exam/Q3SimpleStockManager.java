package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 3i
 */
public class Q3SimpleStockManager {

    /**
     * A new product has been introduced.
     *
     * @param sku The product’s sku
     * @param name The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String name, double price) {
        // FIXME Question 3ia: complete this function
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {
       return null; // FIXME Question 3ib: complete this function
    }

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        return 0; // FIXME Question 3ic: complete this function
    }

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        return 0; // FIXME Question 3id: complete this function
    }

    /**
     * An product has been sold; reduce current stock accordingly.
     *
     * @param sku The product’s sku
     * @param sold The quantity sold
     * @return The number of items of stock remaining after the sale
     */
    public int sale(String sku, int sold) {
        return -1; // FIXME Question 3ie: complete this function
    }

    /**
     * New stock has arrived; increase current stock accordingly.
     *
     * @param sku The product’s sku
     * @param added The quantity newly arrived
     */
    public void addStock(String sku, int added) {
        // FIXME Question 3if: complete this function
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        // FIXME Question 3ig: complete this function
    }

    /**
     * Stock has been carefully counted. Set current stock correctly.
     *
     * @param sku The product’s sku
     * @param actual The quantity actually in the store
     * @return The stock loss or gain (new current – old current)
     */
    public int setActualStock(String sku, int actual) {
        return 0;  // FIXME Question 3ih: complete this function
    }

    /**
     * Return the number of items required for a given product
     * in order to reach the target stock for that item (target - stock)
     *
     * @param sku The SKU of the item to be queried
     * @return The difference between target and actual stock for that item
     */
    public int getStockRequired(String sku) {
        return -1; // FIXME Question 3ii: complete this function
    }

    /**
     * @return the value of the currently held stock (the price of the
     * product multiplied by the number of items in stock, for all items).
     */
    public double totalStockValue() {
        return 0; // FIXME Question 3ij: complete this function
    }
}
