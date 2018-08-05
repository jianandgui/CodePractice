package sort;

import java.io.File;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0, 4, 2, 1, 3};
//        //sort(arr, 0, arr.length - 1);
//        //sort3Way(arr, 0, arr.length - 1);
//        //bubbleSort(arr);
////        selectSort(arr);
////        binaryInsertSort(arr);
////        mergeSort(arr, 0, arr.length - 1);
//        heapSort(arr);


//        readFile("/home/yang/ssd");
//        random();
//        sort3way(arr, 0, arr.length-1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(" " + arr[i]);
//        }
//        Scanner scanner = new Scanner(System.in);
//        String s1 = scanner.next();
//        String s2 = scanner.next();
//        String tmp;
//        if (s1.length() < s2.length()) {
//            tmp = s1;
//            s1 = s2;
//            s2 = tmp;
//        }
//        System.out.println(getMax(s1,s2));

//        String s = scanner.next();
//        System.out.println(getMin(s));

        String s = "hell0004567oworld520helloworld13145";
        System.out.println(getIntMax(s));
//        System.out.println(s.substring(0,5));
    }

    public static int getIntMax(String s) {
        int high = 0;
        int res = Integer.MIN_VALUE;
        int length = s.length();
        for (int low = 0; low < length; low++) {
            if (s.charAt(low) - '0' >= 0 && s.charAt(low) - '0' <= 9) {
                high = low;
                while (s.charAt(high) - '0' >= 0 && s.charAt(high) - '0' <= 9 && high < length-1 ) {
                    high++;
                }
                if (high != low) {
                    int curMax;
                    //此时分情况
                    //如果是最后一个数且是最后
                    if (high == length - 1 && s.charAt(high) - '0' >= 0 && s.charAt(high) - '0' <= 9) {
                        curMax = Integer.parseInt(s.substring(low, high) + s.charAt(high));
                    }else {
                        curMax = Integer.parseInt(s.substring(low, high));
                    }
                    if (curMax > res) {
                        res = curMax;
                    }
                }
                low = high;
            }
        }
        return res;
    }

    public static void print(int length, int[] arr) {

    }


    public static int getMax(String s1, String s2) {
        int sum = 0;
        int length = s2.length();//短的
        int length2 = s1.length();//长的

        int tmp;
        for (int i = 0; i < length2 - length + 1; i++) {
            tmp = i;
            for (int j = 0; j < length; j++) {
                if (s2.charAt(j) != s1.charAt(tmp++)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int getMin(String s) {
        int length = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add((int) s.charAt(i));
        }

        if (!list.contains(1)) {
            return 1;
        }

        return 1;

    }


    public static void readFile(String path) {
        if (path == null) {
            return;
        }
        File[] files = new File(path).listFiles();//获取所有文件
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名是"+file);
            }
            if (file.isDirectory()) {
                readFile(file.getPath());
            }
        }
    }

    public static void sort3way(int[] arr, int leftEnd, int rightStart) {
        if (leftEnd >= rightStart) {
            return;
        }
        int le = leftEnd;
        int cur = leftEnd + 1;
        int rs = rightStart;
        int flag = arr[le];
        while (cur <= rs) {
            if (flag < arr[cur]) {
                exchange(arr, cur++, le++);
            } else if (flag > arr[cur]) {
                exchange(arr, cur, rs--);
            }else {
                cur++;
            }
        }

        sort3way(arr, leftEnd, le - 1);
        sort3way(arr, rs + 1, rightStart);
    }

    public static void random() {
        Set<Integer> result = new HashSet<>(100);
        Random random = new Random();
        while (result.size() < 100) {
            int val = random.nextInt(10000000);
            result.add(val);
        }
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int partion = getPartion(arr, low, high);
        sort(arr, low, partion - 1);
        sort(arr, partion + 1, high);
    }

    public static int getPartion(int[] arr, int low, int high) {
        int flag = arr[low];
        while (low < high) {
            while (low < high && arr[high] > flag) {
                high--;
            }
            exchange(arr, low, high);
            while (low < high && arr[low] < flag) {
                low++;
            }
            exchange(arr, low, high);
        }
        return high;
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }


    public static void sort3Way(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int begin = low;
        int i = begin + 1;
        int end = high;
        int flag = arr[begin];
        while (i <= end) {//指针相遇就停止
            if (arr[i] < flag) {
                exchange(arr, i++, begin++);//左移
            } else if (arr[i] > flag) {
                exchange(arr, i, end--);//右移
            }else {
                i++;//相等后移
            }
        }
        sort3Way(arr, low, begin - 1);
        sort3Way(arr, end + 1, high);
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    exchange(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void selectSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(arr,i,minIndex);
            }
        }
    }

    //二分插入
    public static void binaryInsertSort(int[] arr) {
        int length = arr.length;
        for (int i=1;i<length;i++) {
            int low=0;//必须每次要将low指针重置 坑！
            int high;
            int mid;
            int cur;
            high = i - 1;
            cur = arr[i];
            while (low <= high) {
                mid = low + (high - low) / 2;//必须有个值记录 不能用low 或者high指针去比较
                if (cur > arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j=i;j>low;j--) {
                arr[j] = arr[j-1];
            }
            arr[low] = cur;
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, mid + 1, high);
    }

    public static void merge(int[] arr, int leftS, int leftE, int rightS, int rightE) {
        if (leftS == rightE) {
            return;
        }
        int[] tmp = new int[rightE - leftS + 1];
        int left = leftS;
        int right = rightS;
        int k = 0;
        while (left <= leftE && right <= rightE) {
            if (arr[left] < arr[right]) {
                tmp[k++] = arr[left++];
            }else {
                tmp[k++] = arr[right++];
            }
        }
        while (left <= leftE) {
            tmp[k++] = arr[left++];
        }
        while (right <= rightE) {
            tmp[k++] = arr[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[leftS + i] = tmp[i];
        }
    }

    public static void heapSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            buildHeap(arr, length - i - 1);
            exchange(arr, 0, length - i - 1);
        }
    }


    public static void buildHeap(int[] arr, int lastIndex) {
        //从最后一个子节点的父节点开始建堆
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int curIndex = i;//最后一个子节点的父节点 i游标不能动
            while (curIndex * 2 + 1 <= lastIndex) {//这里
                int maxIndex = curIndex * 2 + 1;
                if (maxIndex < lastIndex) {
                    if (arr[maxIndex] < arr[maxIndex+1]) {
                        maxIndex++;
                    }
                }
                if (arr[curIndex] < arr[maxIndex]) {
                    exchange(arr, curIndex, maxIndex);
                    curIndex = maxIndex;//根据换下来的父节点比较值
                } else {
                    break;
                }
            }
        }
    }



}

