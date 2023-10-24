import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
	   if (super.isEmpty()) {
		   super.push(val);
	   }
	   else if (front.next == null) {
		   if (this.compare.compare(val, front.val) >= 0) {
			   Node temp = new Node(val); 
			   temp.next = front;
			   front = temp;
		   }
		   else {
			   Node temp = new Node(val); 
			   super.push(val);
		   }
	   }
	   else {
		   Boolean flag = false;
		   Node curr = front;
		   Node prev = front;
		   while (curr != null) {
			   if (this.compare.compare(val, curr.val) >= 0) {
				   flag = true;
				   Node temp = new Node(val);
				   temp.next = prev.next;
				   if (curr.next == front.next) {
					   front = temp;
				   }
				   else {
					   prev.next = temp;
				   }
			   }
			   prev = curr;
			   curr = curr.next;
		   }
		   if (flag == false) {
			   Node temp = new Node(val);
			   end.next = temp;
			   temp.next = null;
		   }
	   }
	   
	  // else {
		   	
	   //}
	   
   }

}
