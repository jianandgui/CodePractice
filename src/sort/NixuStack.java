package sort;

import java.util.Stack;

public class NixuStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        nixu(stack);
        while (!stack.isEmpty()) {
            System.out.printf(stack.pop() + " ");
        }
    }


    public static void nixu(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = deleteLast(stack);
        nixu(stack);
        stack.push(last);
    }

    //返回并删除最底层的一个元素 其他的还是要原顺序压入进去
    public static int deleteLast(Stack<Integer> stack) {
        int last = stack.pop();
        if (stack.isEmpty()) {
            return last;
        }else {
            int index = deleteLast(stack);
            stack.push(last);
            return index;
        }
    }
}
