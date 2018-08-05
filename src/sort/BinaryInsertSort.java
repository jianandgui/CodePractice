package sort;

public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0,4,2,1,3};
        binaryInsertSort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(" "+arr[i]);
        }
    }

    public static void binaryInsertSort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int low=0;
            int high=i-1;
            int cur=arr[i];
            int mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (cur<arr[mid]){
                    high = mid-1;
                }else {
                    low = mid + 1;
                }
            }
            for (int j=i;j>low;j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = cur;
        }
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
