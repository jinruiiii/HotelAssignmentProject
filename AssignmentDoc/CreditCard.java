package Assignment;

import java.util.Scanner;

/**
 * 
 * @author joel
 * @author jinrui
 * @author jamie
 * @author tan yu
 *
 */
public class CreditCard {
	
	/**
	 * Displays the printed name on the <code>Guest's<code> credit card.
	 */
    private String cardHolderName;
    
    /**
     * Displays the credit card number on the <code>Guest's<code> credit card.
     */
    private String creditCardNumber;
    
    /**
     * Displays the expiry date on the <code>Guest's<code> credit card.
     */
    private String expirationDate;
    
    /**
     * Constructs an empty credit card holder and asks for the guest's credit card details.
     */
    CreditCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input card holder name");
        this.cardHolderName = sc.nextLine();
        System.out.println("Input credit card number");
        this.creditCardNumber = sc.nextLine();
        System.out.println("Input expiration date");
        String date = sc.nextLine();
        this.expirationDate = CheckDate.getInput(date);
    }
    
    /**
     * Gets the name of the <code>Guest</code>, if the <code>Guest</code> has a credit card. 
     * @return the printed name on the <code>Guest</code>'s credit card. 
     */
    public String getCardHolderName(){
        return cardHolderName;
    }
    
    /**
     * Sets the name of the <code>Guest</code>, if the <code>Guest</code> has a credit card.
     * @param cardHolderName 	the printed name on <code>Guest</code>'s credit card. 
     */
    public void setCardHolderName(String cardHolderName){
        this.cardHolderName = cardHolderName;
    }
    
    /**
     * Gets the credit card number from the <code>Guest</code>, if the <code>Guest</code> has a credit card.
     * @return the number of the <code>Guest</code>'s credit card to display. Every credit card number should be unique.
     */
    public String getCreditCardNumber(){
        return creditCardNumber;
    }
    
    /**
     * Sets the credit card number from the <code>Guest</code>, if the <code>Guest</code> has a credit card.
     * @param creditCardNumber	the number of the <code>Guest</code>'s credit card to display. Every credit card number should be unique.
     */
    public void setCreditCardNumber(String creditCardNumber){
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Gets the expiry date from the <code>Guest</code>'s credit card, if the <code>Guest</code> has a credit card.
     * @return	the <code>Guest</code>'s credit card's expiry date.
     */
    public String getExpirationDate(){
        return expirationDate;
    }
    
    /**
     * Sets the expiry date from the <code>Guest</code>'s credit card, if the <code>Guest</code> has a credit card.
     * @param expirationDate	the <code>Guest</code>'s credit card's expiry date.
     */
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
}
