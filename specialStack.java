/*
Implement Special stack data structure
Question: 
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.

Example:

Consider the following SpecialStack
16  --> TOP
15
29
19
18

When getMin() is called it should return 15, which is the minimum 
element in the current stack. 

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18 which is the minimum 
in the current stack.

Algo:
The idea is to maintain two stacks: actual stack and an auxilliary stack. Actual stack will store all the actual values pushed in the stack
and auxilliary stack will store the minimum value of the values stored in the actual stack. The idea for pushing the elements in the auxilliary stack is that if the new element is greater than the top of the auxilliary stack than push the top element to the auxilliary stack otherwise push the new element to the auxilliary stack.

*/



//stack implementation in Java

class Stack
{
    protected int actual[];
    protected int auxilliary[];
    protected int top, top1, size;

    /*  Constructor for Stack */
    public Stack(int n)
    {
        size = n;
        actual = new int[size];
        auxilliary = new int[size];
        top = -1;
	top1=-1;
    }

    /* Function to check if the stack is empty */
    public boolean isEmpty()
    { 
        if(top1<=-1)
            return true;
        return false;
    }

    /* Function to check if the stack is full */
    public boolean isFull()
    {
        if(top1>=(size-1))
            return true;
        return false;
    }

    /* Function to push the element in the stacks*/
    public void push(int a)
    {
        if(isFull())
        {
            System.out.println("Overflow");
	    System.exit(0);
        }
	/* If the new element is greater than the top of
	   the auxilliary stack than push the top element to 
           the auxilliary stack otherwise push the new element */
        else
        {
	    actual[++top]=a;
	    if(isEmpty())
		auxilliary[++top1]=a;
	    else
	    {
	        int temp = peek();
	        if(temp<a)
		    auxilliary[++top1] = temp;
	        else
	            auxilliary[++top1] = a;
	    }
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
            int element = actual[top--];
	    int temp = auxilliary[top1--]; 
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
            return auxilliary[top1];
        return -1;
    }

    /* Function to print the minimum value */
    public void getMin()
    {
        if(isEmpty())
	{
            System.out.println("Underflow");
	    System.exit(0);
        }
	else
            System.out.println(auxilliary[top1]);
    }
}

/*  Class Stack implementation */
public class specialStack
{
    public static void main(String []args)
    {
        /* Creating object of class Stack */
        Stack s = new Stack(10);
	s.push(34);
	s.push(5);
	s.push(10);
	s.getMin();
	s.pop();
	s.pop();
	s.push(25);
	s.push(40);
	s.push(8);
	s.getMin();
    }
}
