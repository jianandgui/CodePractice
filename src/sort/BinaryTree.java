package sort;

import java.util.*;

public class BinaryTree {

    static class Node{
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(5);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right = new Node(7);
        head.right.left = new Node(6);
        head.right.right = new Node(8);
        List<Integer> list = new ArrayList<>();
        int k = 4;
        getArr(head,list);

        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(getSlideWindow(num,3).size());


    }

    public static ArrayList<Integer> getSlideWindow(int[] num, int size) {
        // 思路应该要清除
        // 就是利用一个队列 将下标入队 然后比它小的就进去
        // 比它大的就弹出直到为空 不过应该有一个开始的初始值
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int length = num.length;
        int curIndex = 0;
        while (curIndex < length) {
            //注意有窗口过期 要删除
            while (!queue.isEmpty() && num[queue.peekLast()] < num[curIndex]) {
                queue.pollLast();// 队头应该是最大值
            }
            //什么时候加入最大值呢
            queue.offerLast(curIndex);
            if (queue.peekFirst() == curIndex - size) {
                //将过期的数据弹出来 加入队列
                arrayList.add(num[queue.pollFirst()]);
            }
            curIndex++;
        }
        return arrayList;
    }

    //找第K大的数字
    public static void getArr(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getArr(root.left,list);
        list.add(root.value);
        getArr(root.right, list);
    }

    public static String Serialize(Node head) {
        if (head == null) {
            return "#!";
        }
        String res = head.value + "!";
        res += Serialize(head.left);
        res += Serialize(head.right);
        return res;
        }

    public static Node reSerializa(Queue<String> queue) {
        String str = queue.poll();
        if (str == "#") {
            return null;
        }
        Node root = new Node(Integer.valueOf(str));
        root.left = reSerializa(queue);
        root.right = reSerializa(queue);
        String s = "";
        s.split("!");
        return root;


    }

    public static Node help(String str){
        String[] strs = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.add(strs[i]);
        }
        return ReCon(queue);
    }

    public static Node ReCon(Queue<String> queue) {
        String res = queue.poll();
        if (res == "#") {
            return null;
        }
        Node root = new Node(Integer.valueOf(res));
        root.left = ReCon(queue);
        root.right = ReCon(queue);
        return root;
    }





}
