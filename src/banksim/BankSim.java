
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
        
        //CircleQueue<CustomerItem> Queue = new CircleQueue<CustomerItem>();
        AllRandoms Random = new AllRandoms();
        ArrayList<CustomerItem> TellerWindow = new ArrayList<CustomerItem>();
        ArrayList<Integer> FinishedTime = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int SimLength = 0;
        
        
        System.out.println("Welcome to the bank line simulation!"); 
        
        //Set the bounds of the transactions
        Random.SetBounds();
        //Generate the initial customers
        Random.GenerateCustomer();
           
        
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

            
            x++;
            }
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



/*//Remove customers who are done
            if(TellerWindow.isEmpty() == false){               
                for(int i=0; i<TellerWindow.size(); i++){       
                    CustomerItem person = TellerWindow.get(i);
                    if(TellerWindow.isEmpty() == false && 
                            TellerWindow.get(i).TimeNeeded == 0){
                        System.out.println("Done with " + 
                                TellerWindow.get(i).TransType +
                                " of length " +
                                TellerWindow.get(i).OrigTimeNeeded + 
                                " at time " + x);
                        
                        FinishedTime.add(x-TellerWindow.get(i).StartTime);
                        TellerWindow.remove(i);
                        i=0;
                        TellerOpen++;
                    }
                }
            } */