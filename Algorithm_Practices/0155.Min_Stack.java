/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
class MinStack {
    
    // Min stack to store all minimums in order
    Stack<Integer> minStack = new Stack<Integer>();
    // Data stack to store all data for LIFO operation
    Stack<Integer> dataStack = new Stack<Integer>();

    int minimum = Integer.MAX_VALUE;
    
    public MinStack() {

    }
    
    public void push(int x) {
        if (minStack.empty()) {
            minStack.push(x);
            minimum = x;
        } else {
            if (minimum >= x) {
                minStack.push(minimum);
                minimum = x;
            }
        }
        dataStack.push(x);
    }
    
    public void pop() {
        if (minimum == dataStack.pop()) minimum = minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minimum;
    }
}
