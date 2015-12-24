/*Question: 
Create a data structure kStacks that represents k stacks. Implementation of kStacks should use only one array, i.e., k stacks should use the same array for storing elements. Following functions must be supported by kStacks.

push(int x, int sn) –> pushes x to stack number ‘sn’ where sn is from 0 to k-1
pop(int sn) –> pops an element from stack number ‘sn’ where sn is from 0 to k-1*/

/*Algo:
  the solution is that two arrays are created. one to store all the stacks and other to store the indexes of the elements which are pushed to the stacks. the array arr[] is divided into slots n/k each with n being the size of the array and k being the number of stacks i.e.   arr[0] to arr[(n/k)-1] will represent the first stack, arr[(n/k)] to arr[(2n/k)-1] will represent the second stack and so on.. */


//stack implementation in Java

class Stack
{
    protected int arr[];
    /*index array is used to store the indexes of the current
      element position of the respective stack*/
    protected int index[];

    /*  Constructor for Stack */
    public Stack(int n, int k)
    {
    /*k is the size of each stack*/
        arr = new int[n];
        index = new int[n/k];
	/*initialise index array with the initial position of
          each stack */
    	for(int i=0;i<index.length;i++)
	{
	    /*temp is udes to store the index of each stack and
	      is thus increamented accordingly*/
	    int temp=0;
	    index[i]=temp;
            temp+=k;
        }
    }

    /*method to check if the stack is empty*/
    public boolean isEmpty(int s)
    {
	if(index[s]==((s-1)*10))
            return true;
	else
	    return false;
    }

    /*method to check if the stack is full*/
    public boolean isFull(int s)
    {
	if(index[s]==(s*10))
            return true;
	else
	    return false;
    }

    /*function to push the element in stack number s*/
    public void push(int element, int s)
    {
        if(isFull(s))
	{
            System.out.println("This stack is already full");
	    System.exit(0);
        }
	else
	{
	/*position will contain the currently empty index
          of stack s and after the element is pushed onto
          that index it is increamented*/
	    int position = index[s];
	    arr[position]=element;
	    index[s]++;
	}
    }

    /*function to pop the element form stack s*/
    public int pop(int s)
    {
	if(isEmpty(s))
	{
	    System.out.println("Stack is empty no element to pop");
	    System.exit(0);
	}
	else
	{
	/*position will contain the index where element can be inserted
          in that stack. hence (position-1) is used to get the current
          element in the stack s*/
	    int position = index[s];
            int element = arr[position-1];
            index[s]--;
            return element;
	}
        return -1;
    }
}

/*  Class Stack implementation */
public class kStacks
{
    public static void main(String []args)
    {
        /* Creating object of class Stack with array size of 50 i.e. 
           5 stacks with each of size 10 are implemented*/
        Stack s = new Stack(50,5);
        s.push(12,2);
	s.push(13,2);
	s.push(14,2);
	s.push(15,2);
	s.push(10,1);
        System.out.println("element popped from stack 2 is: "+s.pop(2));
	System.out.println("element popped from stack 2 is: "+s.pop(2));
	System.out.println("element popped from stack 1 is: "+s.pop(1));
	System.out.println("element popped from stack 1 is: "+s.pop(1));
    }
}
