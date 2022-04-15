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
public class Guest {
	

    private IdentityCard ic;
    
    private CreditCard cc = null;
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
public class Guest {
	
	/**
	 * the details associated with the guest from his Identity Card.
	 */
    private IdentityCard ic;
    
    /**
     * the credit card details associated with the Guest.
     */
    private CreditCard cc = null;

    /**
     * Constructs a new guest entry that takes in the guest's identification details. 
     */
    Guest(){
        Scanner sc = new Scanner(System.in);
        this.ic = new IdentityCard();
    }
    
    /**
     * Retrieves the IdentityCardand its details associated with the Guest, assuming that every Guest has an Identity card.
     * @return	the Guest's IdentityCard.
     */
    public IdentityCard getIc(){
        return this.ic;
    }

    /**
     * Retrieves the CreditCard and its details associated with the Guest, if the Guest has a credit card.
     * @return	the Guest's CreditCard.
     */
    public CreditCard getCC(){
        return cc;
    }
}
    /**
     * Constructs a new <code>gust</code> entry that takes in the guest's identification details. 
     */
    Guest(){
        Scanner sc = new Scanner(System.in);
        this.ic = new IdentityCard();
    }
    
    /**
     * Retrieves the <code>IdentityCard</code> and its details associated with the <code>Guest</code>, assuming that every <code>Guest</code> has an Identity card.
     * @return	the <code>Guest</code>'s <code>IdentityCard</code>.
     */
    public IdentityCard getIc(){
        return this.ic;
    }

    /**
     * Retrieves the <code>CreditCard</code> and its details associated with the <code>Guest</code>, if the <code>Guest</code> has a credit card.
     * @return	the <code>Guest</code>'s <code>CreditCard</code>.
     */
    public CreditCard getCC(){
        return cc;
    }
}
