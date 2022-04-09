import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author joell
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class Menu{
	
	/**
	 * Stores the number of food items on the menu
	 */
    private int numFood;
    
    /**
     * Stores a type of food in the menu 
     */
    private Food food;
    
    /**
     * Contains a list of foods to be displayed on the menu
     */
    ArrayList<Food> foods = new ArrayList<Food>();
    
    /**
     * Displays the name of the food item, its preparation method and its price on the menu. 
     */
    public void printMenuItems() {
        String format = "%-20s%-20s%-20s%n";
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.printf(format, "Name", "Preparation", "Price($)");
        System.out.printf(format, "================", "==================", "==================");
        for (int i =0; i<foods.size();i++) {
            System.out.printf(format, foods.get(i).getName(), foods.get(i).getPrepMethod(), df.format(foods.get(i).getPrice()));
        }
    }

    /**
     * Checks if the food item is not already present in the current menu, add it to the menu.
     * @param food	the type of food item to be added to the menu
     * @return true when the current food item has not been added into the menu and stores it in the <code>foods</code> list, 
     * 		   otherwise the food item will not be added to the menu.
     */
    public boolean addFood(Food food) {
        for (int i =0; i<foods.size();i++) {
            if (foods.get(i).getName().equals(food.getName()))
                return false;
        }
        foods.add(food);
        return true;
    }
    
    /**
     * Checks if the food item is present in the current menu, remove it from the menu.
     * @param food	the type of food item to be removed from the menu
     * @return true when the current food item is already in the menu and removes it from the <code>foods</code> list, 
     * 		   otherwise the food item will not be removed from the menu.
     */
    public boolean removeFood(String name){
        for (int i = 0; i < foods.size(); i++){
            if (foods.get(i).getName().equals(name)){
                foods.remove(i);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gives the user the option to update the food item on the current menu, inlcuding its name, preparation method, and its price,
     * only if the food item is present on the current menu. Otherwise, there will be no update to the food items of the menu.
     * @param name the name of the food item to be updated in the current menu.
     * @return	true when the food item has been successfully updated on the current menu, otherwise there will be no update to the
     * 			current menu.
     */
    public boolean updateMenu(String name) {
    	Scanner sc = new Scanner(System.in);
    	
    	for (int i =0; i<foods.size();i++) {
	    	if (foods.get(i).getName().equals(name)) {
	    		boolean update = true;
	    		while(update) {
	    		System.out.println("What would you like to update?");
	        	System.out.println("(1) Name");
	        	System.out.println("(2) Preparation");
	        	System.out.println("(3) Price($)");
	        	System.out.println("(4) Exit");
	        	int option = sc.nextInt();
	        	sc.nextLine();
		        	switch(option) {
		    	    	case 1:
		    	    		System.out.println("Enter New Name of food");
		    	    		String newName = sc.nextLine();
		    	    		foods.get(i).setName(newName);
		    	    		break;
		    	    	case 2:
		    	    		System.out.println("Enter New Preparation Method of food");
		    	    		String prep = sc.nextLine();
		    	    		foods.get(i).setPrepMethod(prep);
		    	    		break;
		    	    	case 3:
		    	    		System.out.println("Enter New Price of food");
		    	    		double price = sc.nextDouble();
		    	    		foods.get(i).setPrice(price);
		    	    		break;
		    	    	case 4:
		    	    		update = false;
		    	    		break;
		        	}
	        	}
	        	return true;
	    	}
    	}
    	
    	return false;
    }
}
