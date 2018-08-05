package sort;

import java.util.Stack;

public class TwoStack {
    public static void main(String[] args) {
        TwoStack stack1 = new TwoStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.printf(stack1.pop()+" ");
        System.out.printf(stack1.pop()+" ");
        System.out.printf(stack1.pop()+" ");
        System.out.printf(stack1.pop()+" ");
    }

    //两个栈实现队列
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public  void push(int val) {
        help.push(val);
    }

    public int pop() {
        if (stack.isEmpty()) {
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
        }
        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            while (!help.isEmpty()) {
                stack.push(help.pop());
            }
        }
        return stack.peek();
    }


}
