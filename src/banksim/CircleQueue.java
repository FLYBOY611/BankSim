/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banksim;


public class CircleQueue<T> implements QueueADT<T> {

    private final static int DEFAULT_CAPACITY = 100;
    private int front; 
    private int rear;
    private int count;
    private T[] queue;
    
    //Creates an empty queue of size InitialCapacity
    //Names the queue 'queue'
    public CircleQueue (int InitialCapacity){
        front = rear = count = 0;
        queue = (T[]) (new Object[InitialCapacity]);
    }
    
    //Creates and empty queue using the default capacity
    public CircleQueue(){
        this(DEFAULT_CAPACITY);
    }
        
    //Puts a new item at the back of the queue
    //Expands the queue if there isn't enough space
    public void enqueue(T element) {
        if (size() == queue.length){
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear+1) % queue.length;
        
        count++;
    }
    
    public T dequeue() /* throws EmptyCollectionException */ {
        if (isEmpty()){
            //throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front+1) % queue.length;
        
        count--;
        
        return result;
        
    }

    //Returns the first item in the queue
    public T first() {
        return queue[front];
    }

    //Checks to see if the queue is empty
    public boolean isEmpty() {
        
        if(front == rear){
            return true;
        }else{
        return false;
        }
    }

    //Returns the size of the queue
    public int size() {
        
        int size = rear - front;
        if (size < 0){
            size += queue.length;
        }
            return size;
        
    }
    
    //Gives us a new array with twice the capacity of the old
    private void expandCapacity(){
        T[] larger = (T[]) (new Object[queue.length*2]);
        
        for (int scan = 0; scan < count; scan++){
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }
        
        front = 0;
        rear = count;
        queue = larger;
    }
    
    public String toString(){
        String answer = "";
        int scan = front;

		while (scan != rear) {
			answer += queue[scan].toString() + "\n";
			scan = (scan+1) % queue.length;
		}
        
        return answer;
    }
}
