package sort;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(8);
        minStack.push(7);
        minStack.push(9);
        minStack.push(6);

        minStack.pop();
        System.out.println(minStack.peek());

        minStack.pop();
        System.out.println(minStack.peek());

        minStack.pop();
        System.out.println(minStack.peek());

        minStack.pop();
        System.out.println(minStack.peek());
    }

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    //实现保存当前栈的最小值的栈
    public void push(int val) {
        if (min.isEmpty() || val < min.peek()) {
            min.push(val);
        }
        data.push(val);
    }

    public int pop() {
        if (min.peek() == data.peek()) {
            min.pop();
        }
        return data.pop();
    }

    public int peek() {
        if (!min.isEmpty())
        return min.peek();

        return -1;
    }

}
