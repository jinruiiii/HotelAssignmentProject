package Assignment;

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class Food {
	
	/**
	 * Displays the name of the food.
	 */
    private String name;
    
    /**
     * Displays the preparation process of the food.
     */
    private String prepMethod;
    
    /**
     * Displays the price of the food.
     */
    private double price;
    
    /**
     * Constructs a particular type of <code>Food</code> that will be put onto the <code>Menu</code>.
     * @param name			the name of the food. Includes drinks.
     * @param prepMethod	the simplified process of preparing the food. If the food is a drink, the process will be defined as Hot or Cold.
     * @param price			the price of the food. Includes drinks.
     */
    public Food(String name, String prepMethod, double price) {
        this.name = name;
        this.prepMethod = prepMethod;
        this.price = price;
    }
    
    /**
     * Gets the name of the food. 
     * @return	the name of the food.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the price of the food. Should not be a negative value.
     * @return	the price of the food.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Gets the preparation process of the food. 
     * @return	the preparation process of the food.
     */
    public String getPrepMethod() {
        return this.prepMethod;
    }
    
    /**
     * Sets the name of the food. 
     * @param name		the name of the food.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Sets the preparation process of the food. 
     * @param prepMethod	the preparation process of the food.
     */
    public void setPrepMethod(String prepMethod) {
        this.prepMethod = prepMethod;
    }

    /**
     * Sets the price of the food. Should not be a negative value.
     * @param price		the price of the food.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
