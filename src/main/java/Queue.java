public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them

	
	protected class Node {
		T val;
		Node next;
		
		public Node(T val) {
			this.val = val;
			this.next = null;
		}
	}

	Node front;
	Node end;
	
   public Queue()
   {
	   front = null;
	   end = null;
   }


    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   Node newNode = new Node(val);
	   
	   if(isEmpty()) {
		   front = newNode;
		   end = newNode;
	   }
	   
	   else {
		   end.next = newNode;
		   end = newNode;
	   }
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop() throws QueueUnderFlowException 
   {
       if (isEmpty()) {
    	   throw new QueueUnderFlowException("Can't pop, Queue is empty!");
       }
       T val = front.val;
       front = front.next;
       
       if (front == null) {
    	   end = null;
       }
       
       return val;
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return front == null;
   }




}