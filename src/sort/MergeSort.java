package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0, 4, 2, 1, 3};
        mergeSort(arr, 0, arr.length - 1);
        for (int i=0;i<arr.length;i++) {
            System.out.print(" "+arr[i]);
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

    public static void merge(int[] arr, int ls, int le,int rs, int rn) {
        if (ls == rn) {
            return;
        }
        int[] tmp = new int[rn - ls + 1];
        int leftS = ls;
        int rightS = rs;
        int i = 0;
        while (leftS <= le && rightS <= rn) {
            if (arr[leftS] <= arr[rightS]) {
                tmp[i++] = arr[leftS++];
            }else {
                tmp[i++] = arr[rightS++];
            }
        }

        while (leftS <= le) {
            tmp[i++] = arr[leftS++];
        }
        while (rightS <= rn) {
            tmp[i++] = arr[rightS++];
        }

        for (int j=0;i<tmp.length;j++) {
            arr[ls+j] = tmp[j];
        }
    }
}
