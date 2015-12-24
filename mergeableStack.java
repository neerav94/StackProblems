/*Question:
Design a stack with following operations.
a) push(Stack s, x): Adds an item x to stack s
b) pop(Stack s): Removes the top item from stack s
c) merge(Stack s1, Stack s2): Merge contents of s2 into s1.*/

/*Algo:
linked list is used to implement it. 2 pointers for first stack are used, one for head and one to maintain its end and 1 pointer head is used for second stack. when merge is called, end of first stack will point to head of second stack.Following are the methods implemented: a) push() operation will push the element at the head of the corresponding linked list, 
b) pop() will remove the element form the head of the list and,  
c) merge() will merge both the stacks with end of first stack pointing to the head of the second stack.*/

/*node class for the linked list*/
class node
{
    /*info will contain the element to be pushed or popped from the stack
      and next will contain the address of the next node in the list*/
    
    /*last node's next will contain null i.e. it will not point to anything*/
    protected int info;
    protected node next;
}

class stack
{
    node head1; //head pointer of the 1st stack
    node end1;  //end pointer of the 1st stack
    node head2;  //head pointer of the 2nd stack
    int count1;
    int count2;
    /*constructor for stack class*/
    stack()
    {
	head1 = null;
	end1= null;
        head2 = null;
        count1=0;
        count2=0;
    }
    
    /*method to check if the stack is empty*/
    public boolean isEmpty(int s)
    {
        /*check for the stack*/
	if(s==1)
        /*if count of the elements is les than or equal to zero
          that means there are currently no element in the stack*/
            if(count1<=0)
		return true;
            else
		return false;
       
	if(s==2)
        /*if count of the elements is les than or equal to zero
          that means there are currently no element in the stack*/
            if(count2<=0)
		return true;
            else
		return false;
        return false;
    }

    /*method to push the element in the respective stack*/
    public void push(int element, int s)
    {
    /*check in which stack the element is to be pushed*/
	if(s==1)
        {
	/*if the stack is empty than head and end of the stack
          will be the new element to be inserted as it will be
	  the first and last element in the stack*/
	    if(isEmpty(s))
	    {
            /*create the object of the node class*/
	        node t = new node();
                /*element will be pushed to the info section of
		  the node and it will point to nothing*/
                t.info = element;
                t.next=null;
                head1=t;
                end1=t;
		count1++; //to keep the count of number of elements pushed
            }
	    else
	    {
	    /*create the object of the node class*/
		node t = new node();
		/*element will be pushed to the info section of
		  the node and it will point to the current head of the stack
		  and now head will be changed to the latest inserted element*/
		t.info = element;
		t.next = head1;
                head1=t;
                count1++;
            }
	}
        if(s==2)
        {
	    if(isEmpty(s))
	    {
            /*create the object of the node class*/
	        node t = new node();
		/*element will be pushed to the info section of
		  the node and it will point to nothing as it is the
		  first element to be pushed on the stack*/
                t.info = element;
                t.next=null;
                head2=t;
		count2++;
            }
	    else
	    {
            /*create the object of the node class*/
		node t = new node();
		/*element will be pushed to the info section of
		  the node and it will point to the current head of the stack
		  and now head will be changed to the latest inserted element*/
		t.info = element;
		t.next = head2;
                head2=t;
                count2++;
            }
	}
        /*else
	{
	    System.out.println("No such stack");
	    System.exit(0);	
	}*/
    }
    
    /*method to pop from the stack s*/
    public int pop(int s)
    {
	if(s==1)
	{
	    if(isEmpty(s))
	    {
		System.out.println("Stack is empty, no element to be popped");
		System.exit(0);
	    }
	    else
	    {
	    /*popped element will be the head element. After popping out head
	      will point to the next element of the stack*/
		int element = head1.info;
                head1 = head1.next;
                count1--;
		return element;
            }
	}

	if(s==2)
	{
	    if(isEmpty(s))
	    {
		System.out.println("Stack is empty, no element to be popped");
		System.exit(0);
	    }
	    else
	    {
	    /*popped element will be the head element. After popping out head
	      will point to the next element of the stack*/
		int element = head2.info;
                head2 = head2.next;
                count2--;
		return element;
            }
	}

        /*else
	{
	    System.out.println("No such stack");
	    System.exit(0);	
	}*/
    return -1;
    }

    /*method to merge the stacks*/
    public void merge()
    {
     /*the end of the first stack will point to the head of the second stack*/
	end1.next = head2;
        /*print the list after merging both the stacks*/
        node t = head1;
        while(t!=null)
	{
	    System.out.print(t.info+" ");
	    t=t.next;
	}
    
	System.exit(0);
    }
}

/*  Class Stack implementation */
public class mergeableStack
{
    public static void main(String []args)
    {
        /* Creating object of class Stack */
        stack s = new stack();
        s.push(4,1);
        s.push(57,1);
        s.push(25,1);
	s.push(5,2);
	s.push(15,2);       
	System.out.println(s.pop(2)+" is popped from second stack");
        System.out.println(s.pop(1)+" is popped from first stack");
	s.push(100,2);
        s.merge();
    }
}
