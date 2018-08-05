package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0,4,2,1,3};
        bubbleSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(" "+arr[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        //冒泡排序的精髓是每次左右交换 将最大的移到最右边
        for (int i=0;i<arr.length;i++) {
            boolean flag = true;
            for (int j=0;j<arr.length-i-1;j++) {
                if (arr[j] > arr[j + 1]) {//因为这里加1了
                    exchange(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }
        }
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
