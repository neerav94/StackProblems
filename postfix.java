/* Postfix Evaluation
The Postfix notation is used to represent algebraic expressions. The expressions written in postfix form are evaluated faster compared to infix notation as parenthesis are not required in postfix. We have discussed infix to postfix conversion. In this post, evaluation of postfix expressions is discussed.
Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
    a) If the element is a number, push it into the stack
    b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer

Example:
Let the given expression be “2 3 1 * + 9 -“. We scan all elements one by one.
1) Scan ‘2’, it’s a number, so push it to stack. Stack contains ‘2’
2) Scan ‘3’, again a number, push it to stack, stack now contains ‘2 3′ (from bottom to top)
3) Scan ‘1’, again a number, push it to stack, stack now contains ‘2 3 1′
4) Scan ‘*’, it’s an operator, pop two operands from stack, apply the * operator on operands, we get 3*1 which results in 3. We push the result ‘3’ to stack. Stack now becomes ‘2 3′.
5) Scan ‘+’, it’s an operator, pop two operands from stack, apply the + operator on operands, we get 3 + 2 which results in 5. We push the result ‘5’ to stack. Stack now becomes ‘5’.
6) Scan ‘9’, it’s a number, we push it to the stack. Stack now becomes ‘5 9′.
7) Scan ‘-‘, it’s an operator, pop two operands from stack, apply the – operator on operands, we get 5 – 9 which results in -4. We push the result ‘-4′ to stack. Stack now becomes ‘-4′.
8) There are no more elements to scan, we return the top element from stack (which is the only element left in stack).*/


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

    /* Function to push the numbers in the stack*/
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
}

/*  Class Stack implementation */
class postfix
{
    /* Function to evaluate the expression */
    public static int evaluate(int temp1, int temp2, char op)
    {
        int result=0;
        switch(op)
                {
                    case '+':
			result = temp2 + temp1;
                        break;
                    case '-':
                        result = temp2 - temp1;;
			break;
                    case '*':
                        result = temp2 * temp1;;            
			break;
                    case '/':
                        result = temp2 / temp1;;            
			break;
                }
        return result;
    }

    public static void main(String args[])
    {
        /* Creating object of class Stack */
        Stack s = new Stack(50);

        String ch =  "832+-9*3/";
        int len = ch.length();
	for(int i=0;i<len;i++)
        {
            char letter = ch.charAt(i);
            if(Character.isDigit(letter))  //Check if the character is a digit
                s.push(letter-'0');
            else                          //if the character is a operator
            {
                int temp1 = s.pop();
                int temp2 = s.pop();
                int result = evaluate(temp1, temp2, letter);
                s.push(result);
            }
        }
        System.out.println("The answer is: "+s.pop());
    }           
}
