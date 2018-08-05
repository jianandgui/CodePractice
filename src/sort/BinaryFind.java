package sort;

public class BinaryFind {
    public static void main(String[] args) {
        int[] num = {1,1,2,2,3,3,3,4,4,5};
        System.out.println(" "+binaryFindLast(num,1));
    }


    //找第一次出现的
    public static int binaryFind(int[] arr, int val) {
        int mid;
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            //将low指针无限靠近
            if (val > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (val != arr[low]) {
            return -1;
        }else {
            return low;
        }
    }


    //将high指针不断逼近
    public static int binaryFindLast(int[] arr, int val) {
        int mid;
        int high = arr.length - 1;
        int low = 0;
        while (low < high) {
            mid = (low +high+1)/ 2;
            if (val>=arr[mid]) {
                low = mid;
            }else {
                high = mid - 1;
            }
        }
        if (val != arr[high]) {
            return -1;
        }else {
            return high;
        }
    }

}
