
package banksim;

import java.util.Scanner;

/**
 *
 * @author richard.eaton
 */
public class AllRandoms {
        int DepLow = 0;
        int DepHigh = 0;
        int WitLow = 0;
        int WitHigh = 0;
        int TransLow = 0;
        int TransHigh = 0;
        
    public void roller(){
     
        Scanner input = new Scanner(System.in);
     

        System.out.println("We must first begin by establishing the low"
                + "and high limits of each transaction type.");
        
        System.out.println("What is the least amount of time a "
                + "deposit takes?");
        DepLow = input.nextInt();
        
        System.out.println("What is the most amount of time a "
                + "deposity takes?");
        DepHigh = input.nextInt();
        
        System.out.println("What is the least amount of time a "
                + "withdrawl takes?");
        WitLow = input.nextInt();
        
        System.out.println("What is the most amount of time a "
                + "withdrawl takes?");
        WitHigh = input.nextInt();
        
        System.out.println("What is the least amount of time a "
                + "money transfer takes?");
        TransLow = input.nextInt();
        
        System.out.println("What is the most amount of time a "
                + "money transfer takes?");
        TransHigh = input.nextInt();
}

}