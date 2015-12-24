/*Question:
You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

Algo:
First keep popping out the values from the stack till it gets empty and held these values by recursive calling. after the stack gets empty insert the values which were on hold in the bottom of the stack*/


/* stack implementation in java */
class Stack
{
    int []arr;
    int top, size;
    
    /*  Constructor for Stack */
    public Stack(int n)
    {
        size = n;
        arr = new int[size];
        top = -1;
    }

    /* Function to check if the stack is empty */
    public boolean isEmpty()
    { 
        if(top<=-1)
            return true;
        return false;
    }

    /* Function to check if the stack is full */
    public boolean isFull()
    {
        if(top>=(size-1))
            return true;
        return false;
    }

    /* Function to push the element in the stack*/
    public void push(int a)
    {
        if(isFull())
        {
            System.out.println("Overflow");
	    System.exit(0);
        }
        else
        {
            arr[++top]=a;
        }
    }

    /* Function to pop the elements from a stack */
    public int pop()
    {
        if(isEmpty())
	{
            System.out.println("Underflow");
	    System.exit(0);
	}        
	else
        {
            int element = arr[top--];
            return element;
        }
        return -1;
    }

    /* Function to insert the values at the bottom of the stack */
    public void insertAtBottom(int ele)
    {
	if(isEmpty())
            push(ele);
        else
        {
            int temp = pop();
            insertAtBottom(ele);
            push(temp);
	}
    }

    /* Function to reverse the stack recursively using insertAtBottom() */
    public void reverse()
    {
	if(!isEmpty())
	{
            int temp = pop();
            reverse();
            insertAtBottom(temp);
	}
    }

    /* Function to display the complete Stack */
    public void display()
    {
        for(int i=0;i<=top;i++)
	    System.out.print(arr[i]+" ");
    }
}

/*  Class Stack implementation */
public class reverseStack
{
    public static void main(String []args)
    {
        /* Creating object of class Stack */
        Stack s = new Stack(30);
        s.push(1);
        s.push(2);
        s.push(3);
	s.push(4);
	s.push(5);

	System.out.println("Original stack is:");
	s.display();
	System.out.println();
        s.reverse();
	System.out.println("Reversed stack is:");
	s.display();      
	System.out.println();
	System.exit(0);  
    }
}
