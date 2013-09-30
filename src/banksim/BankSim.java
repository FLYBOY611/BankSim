package banksim;
import java.util.ArrayList;
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
        
        AllRandoms Random = new AllRandoms();
        ArrayList<CustomerItem> TellerWindow = new ArrayList<CustomerItem>();
        ArrayList<Integer> FinishedTime = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int SimLength = 0;
        
        
        System.out.println("Welcome to the bank line simulation!");
        
        //Set the bounds of the transactions
        Random.SetBounds();
        
        System.out.println("How many customers will be starting in line?");
        int CustomerNum = input.nextInt();
        //Generate the initial customers
        Random.GenerateCustomer(CustomerNum, 0);
           
        
        System.out.println("The queue size is " + Random.Queue.size());
        System.out.println("The currect customers in line are \n" +
                Random.Queue.toString());
        
       //Now we need to start the simulation....
        System.out.println("One last piece of data before we "
                + "start the simulation!");
        System.out.println("How long would you like the simulation to run?");
        SimLength = input.nextInt();
        
        System.out.println("Running the simulation....");
        int TellerOpen = Random.TellerNum;
        
        
        int x = 0;
        
        //START OF THE SIMULATION
        while(x < SimLength){
   
          //If there's an open teller, and the queue isn't empty
          //put the customer in the teller window ArrayList
          if(Random.Queue.isEmpty() == false){
            for(int j=0; j<TellerOpen; TellerOpen--){
                System.out.println("Customer " +
                                Random.Queue.first().TransType +
                                " of length " +
                                Random.Queue.first().OrigTimeNeeded +
                                " is now being served at time " + x);
                TellerWindow.add(Random.Queue.dequeue());
                
            }
          }
            //Remove customers who are done and open that teller
            if(TellerWindow.isEmpty() == false){
                for(int i=0; i<TellerWindow.size(); i++){
                    CustomerItem person = TellerWindow.get(i);
                    if(person.TimeNeeded == 0){
                        int TimeSpent = x-TellerWindow.get(i).StartTime;
                        System.out.println("Customer " +
                                TellerWindow.get(i).TransType +
                                " of length " +
                                TellerWindow.get(i).OrigTimeNeeded +
                                " is now done at time " + x +
                                ", it took " +
                                TimeSpent + " minutes");
                        //Record how much time it took them
                        FinishedTime.add(TimeSpent);
                        TellerWindow.remove(i).TimeNeeded = 0;
                        i=0;
                        TellerOpen++;
                    }
                }
            }
                      
            //Countdown everyone at a teller
            if(TellerWindow.isEmpty() == false){
                for(int i=0; i<TellerWindow.size(); i++){
                    TellerWindow.get(i).TimeNeeded--;
                }
            }
            
            //A new walkin customer chance
            int CustomerChance = 1 + (int)(Math.random() * ((10 - 1) + 1));
            if(CustomerChance == 1){
                Random.GenerateCustomer(1, x);
                System.out.println("A NEW CUSTOMER HAS ENTERED!");
            } 

            
            x++;
            } //End of while loop
            System.out.println("THE SIMULATION IS DONE \n");
            
            //Calculate the average
            int FinalAverage = 0;
            for(int z=0; z<FinishedTime.size(); z++){
                FinalAverage += FinishedTime.get(z);
            }
            FinalAverage = FinalAverage/FinishedTime.size();
            System.out.println("The average time to get served was: " +
                    FinalAverage);
            System.out.println("Total customers served: " +
                    FinishedTime.size());
            int CustomersLeft = Random.Queue.size() + TellerWindow.size();
            System.out.println("Customers left unserved: " +
                    CustomersLeft);
        }
    }

