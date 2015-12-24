/*Question:
Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. We can only use the following ADT functions on Stack S:

is_empty(S)  : Tests whether stack is empty or not.
push(S)	     : Adds new element to the stack.
pop(S)	     : Removes top element from the stack.
top(S)	     : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example:

Input:  -3  <--- Top
        14 
        18 
        -5 
        30 

Output: 30  <--- Top
        18 
        14 
        -3 
        -5 

Algo:
1) Push all the elements in the stack.
2) Recursively keep popping out the values and hold them.
   Here is the sample code for the above step:
    void popAll()
    {
	if the stack is not empty
	{
            temp = pop();
            popAll();  //recursive calling of the same function
            insertInOrder(temp);  //calling the function to insert the values in order
	}
    }
3) insert them in the stack in sorted order.
   Here is the sample code for the above step:
   void insertInOrder(element)
    {
	if stack is empty
            push(element);
        else
        {
	    if(peek() >= element)
		push(element);
	    else
	    {
                temp = pop();
                insertInOrder(element);
                push(temp);
	    }
	}
    }

*/


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

    /* method to check the top of the stack */
    public int peek()
    {
        if(isEmpty())
	{
            System.out.println("Underflow");
	    System.exit(0);
        }
	else
            return arr[top];
        return -1; 
    }

    /* Function to insert the values in sorted order in the stack */
    public void insertInOrder(int ele)
    {
	if(isEmpty())
            push(ele);
        else
        {
	    if(peek() >= ele)
		push(ele);
	    else
	    {
                int temp = pop();
                insertInOrder(ele);
                push(temp);
	    }
	}
    }

    /* Function to pop all the values from the stack recursively */
    public void popAll()
    {
	if(!isEmpty())
	{
            int temp = pop();
            popAll();
            insertInOrder(temp);
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
public class sortStack
{
    public static void main(String []args)
    {
        /* Creating object of class Stack */
        Stack s = new Stack(30);
        s.push(8);
        s.push(14);
        s.push(-34);
	s.push(0);
	s.push(2);

	System.out.println("Original stack is:");
	s.display();
	System.out.println();
        s.popAll();
	System.out.println("Sorted stack is:");
	s.display();      
	System.out.println();
	System.exit(0);  
    }
}
