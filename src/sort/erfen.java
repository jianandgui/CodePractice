package sort;

import java.util.Arrays;

public class erfen {

    public static void main(String[] args) {
//        System.out.println(sqrt(2));
//        System.out.println(coin(10));
        int[] arr = {1, 1, 2, -1, 3, -3, -2};
//        System.out.println(findSingle(arr));
//        int[] res = findTwoForZero(arr, 4);
//        for (int i = 0; i < 2; i++) {
//            System.out.print(res[i]+" ");
//        }
//        System.out.println(isSquare(6));
//        System.out.println(isPalindrome("abcaaa"));
//        String s = "abpcpleamkdosnkreuy";
//        String[] strings = {"ale", "apple", "monkey", "plea"};
//        System.out.println(findLongestStr(s,strings));

//        System.out.println(getIntMax("helloworld520helloworld1314"));
    }

//    public static int getIntMax(String s) {
//        int xiao = 0;
//        int high = 0;
//        int res = Integer.MIN_VALUE;
//        int length = s.length();
//        while (xiao < length) {
//            if (s.charAt(xiao) -'0' > 0 && s.charAt(xiao)-'0' <= 9) {
//                high = xiao;
//                while (s.charAt(high) - '0' > 0 && s.charAt(high) - '0' <= 9 && high < length) {
//                    high++;
//                }
//                if (s.substring(xiao, high) != null) {
//                    int curMax = Integer.parseInt(s.substring(xiao, high));
//                    if (curMax > res) {
//                        res = curMax;
//                    }
//                }
//            }
//            xiao++;
//        }
//        return res;
//    }

    public static int sqrt(int num) {
        if (num < 1) {
            return -1;
        }
        int low = 1;
        int high = num;
        int mid;
        int res;
        while (low <= high) {
            mid = low + (high - low) / 2;
            res = num / mid;
            if (res == mid) {
                return res;
            } else if (res > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int coin(int num) {
        int level = 1;
        while (num >= 0) {
            num = num - level;//初始值必须是1
            level++;
        }

        return num == 0 ? level - 1 : level - 2;
    }

    //找唯一一个单数
    public static int findSingle(int[] arr) {
        int length = arr.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    //找两个和为0的数
    public static int[] findTwoForZero(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int[] res = new int[2];
        Arrays.sort(arr);
        while (low < high) {
            if (arr[low] + arr[high] < target) {
                low++;
            } else if (arr[low] + arr[high] > target) {
                high--;
            } else {
                res[0] = arr[low];
                res[1] = arr[high];
                return res;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }

    //是否一个数是两个数的平方
    public static boolean isSquare(int target) {
        int low = 0;
        int high = (int) Math.sqrt(target);
        while (low <= high) {
            int res = low * low + high * high;
            if (res > target) {
                high--;
            } else if (res < target) {
                low++;
            } else {
                return true;
            }
        }
        return false;
    }

    //删除一个字符 判断是不是回文字符串
    public static boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        //有两种情况 一种是删除 另一种是不删除
        while (low <= high) {
            if (chars[low] != chars[high]) {
                //这种是删除一个的情况下 只能删除一次
                return deleteOne(chars, low + 1, high) || deleteOne(chars, low, high - 1);
            }
            low++;
            high--;
        }
        return true;
    }

    public static boolean deleteOne(char[] chars, int low, int high) {
        while (low <= high) {
            if (chars[low] != chars[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    class Node {
        Node next;
    }

    //判断链表是否有环
    public static boolean isCycle(Node head) {
        Node low = head;
        Node fast = head;
        while (low != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }


    public static String findLongestStr(String s, String[] strs) {
        String ret="";
        for (String s2 : strs) {
            //这里处理很巧妙 利用跳过来代替删除
            for (int i = 0, j = 0; i < s.length() && j < s2.length(); i++) {
                if (s.charAt(i) == s2.charAt(j)) {
                    j++;//表示匹配上了一个字符 后移
                }
                if (j == s2.length()) {//表示已经匹配到了一个字符串
                    if (s2.length() > ret.length()) {
                        ret = s2;
                    }
                }
            }
        }
        return ret;
    }




}
