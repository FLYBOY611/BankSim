/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banksim;

/**
 *
 * @author Richard
 */
public class CustomerItem {
    
    public String TransType;
    public int TimeNeeded;
    public int TimeSpent;
    
    public String toString(){
        return TransType + " " + TimeNeeded;
    }
}
