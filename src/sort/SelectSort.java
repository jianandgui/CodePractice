package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0,4,2,1,3};
        selectSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(" "+arr[i]);
        }
    }

    public static void selectSort(int[] arr) {
        //选择排序就是每次将最小的元素选出来放在首位  依次比较
        for (int i=0;i<arr.length;i++) {
            int minIndex=i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //可以避免交换的过程
            if (minIndex != i) {
                exchange(arr, i , minIndex);
            }
        }
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
