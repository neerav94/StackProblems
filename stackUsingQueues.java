/*Question:
The problem is opposite of this post. We are given a Queue data structure that supports standard operations like enqueue() and dequeue(). We need to implement a Stack data structure using only instances of Queue*/


/* Java implementation for stack using two queues */
import java.util.*;

class Stack
{
    Queue<Integer> q;
    Queue<Integer> temp;
    /* Constructor for stack class for creating
	the queue instance */
    public Stack()
    {
        q = new LinkedList<Integer>();
	temp = new LinkedList<Integer>();
    }

    /* Function to check if the stack is emtpy */
    public boolean isEmpty()
    {
        if(q.size()==0)
	    return true;
	else
	    return false;
    }

    /* Function to push an element in the stack */
    public void push(int element)
    {
        /* If q is empty than push the element onto it */
	if(isEmpty())
	    q.add(element);

        else
	{
	   /* remove all the elements from q one by one
	   and add these elements in the temporary queue
	   temp */

	    int size = q.size();
	    for(int i=0;i<size;i++)
		temp.add(q.remove());

            /* add element to queue q after it becomes empty */
	    q.add(element);

            /* Enqueue the elements back to q from temp */
	    for(int i=0;i<size;i++)
		q.add(temp.remove());
	}
    }

    /* Function to pop the element */
    public int pop()
    {
        if(isEmpty())
	{
	    System.out.println("Underflow");
	    System.exit(0);	
	}
	return q.remove();
    }

    /* Function to check the first element */
    public int peek()
    {
	if(isEmpty())
	{
	    System.out.println("Underflow");
	    System.exit(0);
	}
	return q.element();    
    }
}

/*  Class Stack implementation */
public class stackUsingQueues
{
    public static void main(String []args)
    {
        /* Creating object of class Stack */
        Stack s = new Stack();
        s.push(4);
        s.push(57);
        s.push(25);
        int num = s.pop();
        System.out.println(num+" is popped from stack");
        System.out.println(s.peek()+" is at the top of the stack");
    }
}
