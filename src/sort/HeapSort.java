package sort;


public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 6, 0,4,2,1,3};
        heapSort(arr, 0, arr.length - 1);
        for (int i=0;i<arr.length;i++) {
            System.out.print(" "+arr[i]);
        }
    }

    //堆排序其实就是选择排序 只是它利用了树的性质 避免了多次排序
    public static void heapSort(int[] arr, int low, int high) {
        for (int i=0;i<arr.length;i++) {
            buildHeap(arr,  arr.length - i - 1);
            exchange(arr, 0, arr.length - i - 1);
        }
    }


    public static void buildHeap(int[] arr,  int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int maxIndex;
            int cur = i;//表示当前父节点  因为会和父节点交换
            while (cur * 2 + 1 <= lastIndex) {//说明有子节点
                maxIndex = cur * 2 + 1;//左子节点
                if (maxIndex < lastIndex) {//说明还有右子节点
                    if (arr[maxIndex] < arr[maxIndex+1]) {
                        maxIndex++;
                    }
                }
                if (arr[maxIndex] > arr[cur]) {
                    exchange(arr, cur, maxIndex);
                    cur = maxIndex;//当前节点换成了父节点交换下来的节点
                    // 因为要保证换了过后还应该保持其他节点的平衡
                }else {
                    break;
                }
            }

        }
    }

    public static void exchange(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
}
