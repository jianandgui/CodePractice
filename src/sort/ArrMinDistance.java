package sort;
import java.util.Stack;

public class ArrMinDistance {
    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = getMinDistance(arr);
        int length = res.length;
        for (int i = 0; i < length; i++) {
            System.out.printf(res[i]+" ");
        }
    }

    public static int[] getMinDistance(int[] arr) {
        int length = arr.length;
        Stack<Integer> stack = new Stack<>();//栈只保存索引
        int[] res = new int[length];
        for (int i=0;i<length;i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
             //弹出栈顶 并压入栈
                int index = stack.pop();//保存的是指针下标
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}


