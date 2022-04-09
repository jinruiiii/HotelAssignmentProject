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
