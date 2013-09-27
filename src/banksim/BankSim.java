/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banksim;
import java.util.Scanner;
/**
 *
 * @author Richard
 */
public class BankSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //CircleQueue<CustomerItem> Queue = new CircleQueue<CustomerItem>();
        AllRandoms Random = new AllRandoms();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the bank line simulation!"); 
        
        //Set the bounds of the transactions
        Random.SetBounds();
        //Generate the initial customers
        Random.GenerateCustomer();
           
        
        System.out.println("The queue size is " + Random.Queue.size());
        System.out.println("The currect customers in line are \n" +
                Random.Queue.toString());
        
       //Now we need to start the simulation....
        System.out.println("Running the simulation....");
    }
}




/*
        int DepLow = 0;
        int DepHigh = 0;
        int WitLow = 0;
        int WitHigh = 0;
        int TransLow = 0;
        int TransHigh = 0;
        
        
        DepLow = input.nextInt();
        
             
        
          
        System.out.println("Welcome to the bank line simulation!");
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
        */
        //System.out.println("Deposit high bound is " + Random.DepHigh);
        //System.out.println("Please enter the type of transaction");
        
        //String entry;
        //entry = input.nextLine();
