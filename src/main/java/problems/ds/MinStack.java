package problems.ds;

import java.util.Stack;

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(20);
        minStack.push(30);
        minStack.push(5);
        minStack.push(1);

        // max, 10, 20, 30, 10, 5, 5, 1  - push
        // pop - 1,


        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();

        System.out.println(minStack.getMin());

    }
}


