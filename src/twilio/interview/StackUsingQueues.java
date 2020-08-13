package twilio.interview;

import java.util.LinkedList;

public class StackUsingQueues {
	/** Initialize your data structure here. */
	
	LinkedList<Integer> stack;
	
    public StackUsingQueues() {
    		stack = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    		if (!stack.isEmpty())
    			return stack.pop();
    		return -1;
    }
    
    /** Get the top element. */
    public int top() {
        if (!stack.isEmpty())
        		return stack.peek();
        return -1;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
