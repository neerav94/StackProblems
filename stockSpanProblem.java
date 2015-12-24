/*Quesion:
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are  {1, 1, 1, 2, 1, 4, 6}

*/


//stack implementation in Java

class Stack
{
    protected int arr[];
    protected int top, size;

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
}

/*  Class Stack implementation */
public class stockSpanProblem
{
    public static void main(String []args)
    {
	/* Creating the array for storing stocks */
	int stock[] = {100, 80, 60, 70, 60, 75, 85};

	/* Creating the array to store the span */
	int span[] = new int[stock.length];

        /* Creating object of class Stack */
        Stack s = new Stack(stock.length);

	/* Since the span of the first stock is 1 */
	span[0]=1;
	/* Push the index of the first stock */
	s.push(0);

	/* Iterate for the rest of the stocks */
        for(int i=1;i<stock.length;i++)
	{
            /* Pop elements from stack while stack is not empty 
               and top of stack is smaller than price[i] */
	    while(!s.isEmpty() && stock[s.peek()]<=stock[i])
		s.pop();
	    
	    /*If the stack gets empty than the price of stock will be
              greater than the price of stocks of all the previous
	      days of the current stock otherwise ELSE price of the stock
	      is greater than the elements after the top of the stack*/
	    if(s.isEmpty())
		span[i] = i+1;
	    else
		span[i] = i-s.peek();
            /*push the index value of the current stock to the stack*/
	    s.push(i);	
	}

	/* Print the span values of the stocks */
	for(int i=0;i<span.length;i++)
	    System.out.print(span[i]+" ");
	System.exit(0);
    }
}
