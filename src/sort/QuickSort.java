package sort;


public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0, 4, 2, 1, 3};
        //sort(arr, 0, arr.length - 1);
        sort3Way(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(" "+arr[i]);
        }
    }

    public static void sort(int[] arrays, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = partion(arrays, low, high);
        sort(arrays, low, mid - 1);
        sort(arrays, mid + 1, high);
    }

    public static int partion(int[] arrays, int low, int high) {
        int flag = arrays[low];
        while (low < high) {
            if (arrays[high] > flag && low < high) {
                high--;
            }
            exchange(arrays, low, high);
            if (arrays[low] < flag && low < high) {
                low++;
            }
            exchange(arrays, low, high);
        }
        return high;
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }


    //分成3块
    // 首先 i的指针移动是为了比较
    // 如果当前值比flag小  就左右交换 然后都++ 然后后移一位
    //如果当前值比flag大  就和he指针交换  比快速排序多了一些交换过程 然后指针左移
    public static void sort3Way(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int ls = begin;
        int he = end;
        int i = begin + 1;
        int flag = arr[begin];
        while (i <= he) {
            if (arr[i] > flag) {
                exchange(arr, i, he--);
            } else if (arr[i] < flag) {
                exchange(arr, ls++, i++);
            } else {
                i++;
            }
        }
        sort(arr, begin, ls - 1);
        sort(arr, he + 1, end);
    }
}
