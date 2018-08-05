package sort;


import java.util.Arrays;
import java.util.Scanner;

public class tonggou {

    //象这种都可以用map  统计数字 距离
    public static void main(String[] args) {
//        System.out.println(longest("abccccdd"));
//        System.out.println(isHuiwenshu(363));
//        tonggou t = new tonggou();
//        System.out.println(t.getHuiWenZiChuan("aaa"));
//        System.out.println(replace("Hello! How are you!"));
//        int[] num = {1,1,2,2,3,3,3,4,4,5};
//        int money = 9;
////        System.out.println(maxNum(num,money));
//        System.out.println(findLast(num,4));
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(2);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(5);
//        Node res = deleteRepeateNode(head);
//        while (res != null) {
//            System.out.print(res.val + " ");
//            res = res.next;
//        }

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();//树的大小
            int[] values = new int[N - 1];//保留树的路径权值
            setValue(scanner, N, values);
            int N2 = scanner.nextInt();//需要获取最大权值的行数
            getMax(scanner, N2, values);
        }

    }


    public static void setValue(Scanner scanner,int N,int[] values) {
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();//获取输入的数字串
            String[] val = line.split(" ");
            int index = Integer.parseInt(val[1]);//获取输入的第二个数字 作为权值下标
            int res = Integer.parseInt(val[2]);
            values[index] = res;//这就相当于保留了权值
        }
    }

    public static void getMax(Scanner scanner,int N2,int[] values) {
        int maxRet = 0;
        for (int i=0;i<N2;i++) {
            String line = scanner.nextLine();//获取需要求权值的字串
            String[] res = line.split(" ");
            int v = Integer.parseInt(res[1]);
            int u = Integer.parseInt(res[0]);
            for (int j=v;i<u;i++ ) {
                maxRet += values[j];
            }
            System.out.println(maxRet);
        }
    }






    //最长的回文字串
    public static int longest(String s) {
        int[] num = new int[128];
        for (char c : s.toCharArray()) {
            num[c]++;
        }
        int sum = 0;
        //统计个数
        for (int i = 0; i < 128; i++) {
            sum += (num[i] / 2) * 2;//这样可以排除1,3,5这种 利用int的特性
        }
        //说明至少有一个字符
        if (sum < s.length()) {
            sum++;
        }
        return sum;
    }


    public static boolean isHuiwenshu(int num) {
        if (num <= 0) {
            return false;
        }
        if (num % 10 == 0) {
            return false;
        }
        if (num < 10) {
            return false;
        }
        int right = 0;
        while (num > right) {
            right = right * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(num);
        System.out.println(right);
        //防止出现363这种除了10 后就相等而不能一样的情况
        return num == right || num == right / 10;
    }


    int num = 0;
    public int getHuiWenZiChuan(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            extendStr(s, i, i);//表示有一个单独的字母
            extendStr(s, i, i + 1);//表示没有
        }
        return num;
    }

    public  void extendStr(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;//向左扩展
            end++;//向右扩展
            num++;
        }
    }

    public static String replace(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if ((c >= 'a' && c <= 'y') || (c >= 'A' && c <= 'Y')) {
                int num = (int) c;
                chars[i] = (char) (num + 1);
            }else {
                if (chars[i] == 'z') {
                    chars[i] = 'a';
                }
                if (chars[i] == 'Z') {
                    chars[i] = 'A';
                }
            }

        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : chars) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    //最多硬币数量
    public static int maxNum(int num[], int money) {
        Arrays.sort(num);
        int length = num.length;//排序
        int low = 0, high = -1;
        int sum = 0;
        //排序过后就是最小的
        while (sum <= money) {
                sum += num[++high];
        }
        if (sum == money) {
            return high;
        }
        if (sum < money) {
            sum += num[high+1];//因为小于 又多加了一位 但是要减去前面的
            //减去多少呢？
            int more = sum - money;
            int moreSum = 0;
            while (moreSum < more) {
                moreSum += num[low++];
            }
        }

        return high - low;
    }

    public static int findFirst(int[] arr, int num) {
        //找到第一个数
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (num > arr[mid]) {
                low = mid + 1;
            }else {
                high = mid;//就是不断向左逼近
            }
            //核心思想是 如果找第一个出现的 那么只有大于low才移动 小于的话low不动  high移动  这样才可以向做探索
            //反之 找最后一个就是只有小于才移动high  大于等于的话就移动low  因为要找最后一个出现的
        }
        if (arr[low] != num) {
            return -1;
        }
        return low;
    }

    public static int findLast(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low < high) {
            mid = (high + low + 1) / 2;
            if (num >= arr[mid]) {
                low = mid;
            }else{
                high = mid-1;
            }
        }
        if (arr[high] != num) {
            return -1;
        }
        return high;
    }

    //设 A 的长度为 a + c，B 的长度为 b + c，
    // 其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
    public static Node isXiangJiao(Node head1, Node head2) {
        Node l1 = head1;
        Node l2 = head2;
        while (l1 != l2) {
            l1 = (l1 == null) ? head2 : l1.next;
            l2 = (l2 == null) ? head1 : l2.next;
        }
        return l2;
    }
    static class Node {
        private Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static int getLastKNode(Node head, int k) {
        //首先判断参数是否异常

        Node cur = head;
        while (cur != null) {
            --k;
            cur = cur.next;
        }
        if (k == 0) {
            return head.val;
        }
        if (k > 0) {
            throw new IllegalArgumentException();
        }

        cur = head;
        while (++k < 0) {
            cur = cur.next;//获取前一节点
        }
        int val = cur.next.val;
        cur.next = cur.next.next;
        return val;
    }

    public static Node deleteRepeateNode(Node head) {
        if (head.next == null) {
            return head;
        }
        Node cur1 = head.next;
        Node pre1 = head;
        Node next1 = null;
        while (cur1 != null) {
            next1 = cur1.next;
            Node cur2 = cur1;
            Node pre2 = pre1;
            Node next2 = null;
            while (cur2 != null) {
                next2 = cur2.next;
                if (pre2.val == cur2.val) {
                    pre2.next = next2;
                } else {
                    pre2 = cur2;
                }
                cur2 = next2;
            }
            pre1 = cur1;
            cur1 = next1;
        }
        return head;
    }

    static class Tree {
        Tree right;
        Tree left;
        int val;

        public Tree(int val) {
            this.val = val;
        }
    }


    public static int getTreeHigh(Tree root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHigh(root.left), getTreeHigh(root.right)) + 1;
    }

    public static Tree reverseTree(Tree root) {
        if (root == null) {
            return null;
        }
        Tree left = root.left;
        root.left = reverseTree(root.right);
        root.right = reverseTree(left);
        return root;
    }

    public static Tree mergeTree(Tree t1, Tree t2) {
        if (t2 == null && t1 == null) {
            return null;
        }
        if (t2 == null || t1 == null) {
            return t2 == null ? t1 : t2;
        }
        Tree root = new Tree(t1.val + t2.val);
        root.left = mergeTree(t1.left, t2.left);
        root.right = mergeTree(t1.right, t2.right);
        return root;
    }




}
