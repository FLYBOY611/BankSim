
package banksim;

import java.util.Scanner;

/**
 *
 * @author richard.eaton
 */
public class AllRandoms {
        int DepLow = 2;
        int DepHigh = 7;
        int WitLow = 3;
        int WitHigh = 5;
        int TransLow = 6;
        int TransHigh = 14;
        
        int TellerNum = 0;
        int CustomerNum = 0;
        
        //I also want to enqueue from this class....not sure if it
        //will cause issues
        CircleQueue<CustomerItem> Queue = new CircleQueue<CustomerItem>();
    
    //Set the high low bounds of the transactions, or use the defaults    
    public void SetBounds(){
     
        Scanner input = new Scanner(System.in);
        String entry;

        System.out.println("We must first begin by establishing the low"
                + "and high limits of each transaction type.");
        System.out.println("Do you want to use the default values"
                + "for the bounds on transactions?  y/n");
        entry = input.nextLine();
        
        if(entry == "n"){
        
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
        
        System.out.println("How many tellers are at the windows today?");
        TellerNum = input.nextInt();
        
        System.out.println("How many customers will be starting in line?");
        CustomerNum = input.nextInt();
}
    public void GenerateCustomer(){
        
        
      
      //For however many initial customers
      for(int i=0; i<CustomerNum; i++){
        CustomerItem thing = new CustomerItem();
        
        //First decide what kind of customer they are
        int CustomerType = 1 + (int)(Math.random() * ((3 - 1) + 1));
        
        //Then find out how much time he needs and enqueue him      
            if(CustomerType == 1){
                     thing.TransType = "Deposit";
                     thing.TimeNeeded = DepLow + (int)(Math.random() * 
                          ((DepHigh - DepLow) + 1));
                     thing.OrigTimeNeeded = thing.TimeNeeded;
                     thing.StartTime = 0;
                     Queue.enqueue(thing);
                     
                }
            if(CustomerType == 2){
                     thing.TransType = "Withdraw";
                     thing.TimeNeeded = WitLow + (int)(Math.random() * 
                          ((WitHigh - WitLow) + 1));
                     thing.OrigTimeNeeded = thing.TimeNeeded;
                     thing.StartTime = 0;
                     Queue.enqueue(thing);
                     
                }
            if(CustomerType == 3){
                     thing.TransType = "Transfer";
                     thing.TimeNeeded = TransLow + (int)(Math.random() * 
                          ((TransHigh - TransLow) + 1));
                     thing.OrigTimeNeeded = thing.TimeNeeded;
                     thing.StartTime = 0;
                     Queue.enqueue(thing);
                     
                }
               
        }
        
    }

}