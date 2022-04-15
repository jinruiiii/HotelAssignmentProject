package Assignment;

/**
 * Interface for generating the total bill for a particular guest's hotel stay when the guest checks out, which return the guest's total room charges and <code>RoomService</code> orders,
 * inclusive of taxes and discounts.
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public interface Payment {
	
	/**
	 * 7% Goods and Services Tax stored as double.
	 */
	final double GST = 0.07;
	
	/**
	 * 7% Goods and Services Tax stored as string.
	 */
	final String stringGST = "7%";
	
	/**
	 * 10% Service tax stored as double.
	 */
	final double serviceTax = 0.1;
	
	/**
	 * 10% Service tax stored as String.
	 */
	final String stringServiceTax = "10%";
	
	/**
	 * 17% in taxes stored as double.
	 */
	final double totalTax = GST + serviceTax;
	
	/**
	 * Gets the payment for either the guest's total room charges or their room service orders.
	 */
	public abstract double getPayment();
	
	/**
	 * Displays the invoice of either the guest's total room charges or their room service orders, billed to the guest.
	 */
	public abstract void printBill();
}
