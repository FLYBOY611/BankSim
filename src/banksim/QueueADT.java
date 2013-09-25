/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banksim;


public interface QueueADT<T> {
    
    //Adds and element to the rear of the queue
    public void enqueue(T element);
    
    //Removes and return the element from the front of the queue
    public T dequeue();
    
    //Returns the first element without removing it
    public T first();
    
    //Returns true if our queue is empty
    public boolean isEmpty();
    
    //Returns the number of elements in the queue
    public int size();
    
    //Returns a string representation of the queue
    public String toString();
    
}
