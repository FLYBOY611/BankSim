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
        
        CircleQueue<CustomerItem> Queue = new CircleQueue<CustomerItem>();
        String entry = "";
        
        System.out.println("Welcome to the bank line simulation!");
        System.out.println("Please enter the type of transaction");
        Scanner input = new Scanner(System.in);
        entry = input.nextLine();
        
        CustomerItem thing = new CustomerItem();
        thing.TransType = entry;
        Queue.enqueue(thing);
        
        
        System.out.println(Queue.size());
        System.out.println(Queue.toString());
    }
}
