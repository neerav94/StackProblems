/*Question:
Given a string reverse it using stack

Algo:
1) Push all the characters one by one onto the stack
2) Pop one by one all the characters form the stack and combine it to the new string.*/


//Java program to reverse a string using stack
import java.util.*;

class Stack
{
    protected char arr[];
    protected int top, size;

    /*  Constructor for Stack */
    public Stack(int n)
    {
        size = n;
        arr = new char[size];
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

    /* Function to add the element in the stack*/
    public void push(char a)
    {
        if(isFull())
	{
            System.out.println("Overflow");
	    System.exit(0);	
	}        
	else
            arr[++top]=a;
    }

    /* Function to pop the elements from a stack */
    public char pop()
    {
        if(isEmpty())
	{
            System.out.println("Underflow");
	    System.exit(0);
	}        
	else
        {
            char element = arr[top--];
            return element;
        }
        return '\0';
    }
}

/*  Class Stack implementation */
public class reverse
{
    public static void main(String args[])
    {
        String name = "This is the string to reverse";
        int len = name.length();
        String reversed = ""; //variable to hold the reversed string

        /* Creating object of class Stack */
        Stack s = new Stack(len); 

        /* pushing the characters of the string one by one */
        for(int i=0;i<len;i++)
            s.push(name.charAt(i));
        
        /* extracting the characters back from the stack */
        /* and appending it to the new string to get the reverse */
        for(int i=0;i<len;i++)
            reversed += s.pop(); 

        System.out.println("The string after reversing is: ");
        System.out.println(reversed);
    }
}
