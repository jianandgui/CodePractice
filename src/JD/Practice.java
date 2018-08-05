package JD;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Practice {

    public static void main(String[] args) {
//        int[] arr = {8, 7, 9, 6, 0, 4, 2, 1, 3};
//        int length = arr.length;
////        quickSort(arr, 0, length-1);
////        bubbleSort(arr);
////        selectSort(arr);
////        bubbleSort(arr);
////        mergeSort(arr, 0, length - 1);
////        heapSort(arr);
//        int arrs[] = {0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 7, 8, 9, 9, 9};
////        System.out.println(getLeftest(arrs, 3));
//  //      System.out.println(getRightest(arrs, 3));
//        sort3Way(arr, 0, length - 1);
//        for (int i = 0; i < length; i++) {
//            System.out.printf(arr[i]+" ");
//        }



    }


    public static String encode(String str) {
        System.out.println(str);
//       if (str == null) {
//       return null;
//       }
//       try {
//       MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
//       messageDigest.update(str.getBytes());
//       return getFormattedText(messageDigest.digest());
//       } catch (Exception e) {
//       throw new RuntimeException(e);
//       }
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(str.toString().getBytes());
            byte[] messageDigest = md.digest();
            for (byte b : messageDigest) {
                int halfbyte = (b >>> 4) & 0x0F;
                int two_halfs = 0;
                do {
                    sb.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                    halfbyte = b & 0x0F;
                } while (two_halfs++ < 1);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    //快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = getMid(arr, low, high);
        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);
    }

    public static int getMid(int[] arr, int low, int high) {
        int flag = arr[low];
        while (low < high) {
            while (arr[high] > flag && low < high) {
                high--;
            }
            swap(arr, low, high);
            while (arr[low] < flag && low < high) {
                low++;
            }
            swap(arr, low, high);
        }
        return high;
    }

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }


    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                return;
            }

        }
    }

    //选择排序
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
                swap(arr, i, minIndex);
            }
        }
    }


    //二分插入排序
    public static void binaryInsert(int[] arr) {
        int length = arr.length;
        int mid;
        for (int i = 1; i < length; i++) {
            int low = 0;
            int high = i - 1;
            int cur = arr[i];
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (cur >= arr[mid]) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            //插入 i代表有序链表的最后一个元素
            for (int j=i;j>low;j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = arr[i];
        }
    }

    //归并排序
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, mid + 1, high);
    }

    //正式归并
    public static void merge(int[] arr,int leftS,int leftE,int rightS,int rightE) {
        if (leftS == rightE) {
            return;
        }
        int left = leftS;
        int right = rightS;
        int[] tmp = new int[rightE - leftS + 1];
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

        for (int i=0;i<tmp.length;i++) {
            arr[i + leftS] = tmp[i];
        }
    }


    //堆排序
    public static void heapSort(int[] arr) {
        int length = arr.length;
        for (int i=0;i<length;i++) {
            buildHeap(arr, length - i - 1);
            swap(arr, 0, length - i - 1);//每次把最大的排到后面去
        }
    }

    public static void buildHeap(int[] arr, int lastIndex) {
        for (int i=(lastIndex-1)/2;i>=0;i--) {
            int curIndex = i;
            while (curIndex * 2 + 1 <= lastIndex) {
                int maxIndex = curIndex * 2 + 1;
                if (maxIndex < lastIndex) {//说明还有右子节点
                    if (arr[maxIndex] < arr[maxIndex+1]) {
                        maxIndex++;//获取最大子节点
                    }
               }
                if (arr[maxIndex] > arr[curIndex]) {
                    //与当前父节点比较
                    swap(arr, maxIndex, curIndex);
                    curIndex = maxIndex;//将换下去的节点又继续比较
                }else {
                    break;
                }
            }
        }
    }

    //二分查找 查找最左边的
    public static int getLeftest(int[] arr, int aim) {
        int low = 0, high = arr.length-1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] < aim) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        if (arr[low] != aim) {
            return -1;
        }
        return low;
    }

    //二分查找最右边的
    public static int getRightest(int[] arr, int aim) {
        int low = 0, high = arr.length - 1;
        int mid;
        while (low < high) {
            mid = (low+high+1)/2;
            if (aim < arr[mid]) {
                high = mid - 1;
            }else {
                low = mid;
            }
        }
        if (arr[high] != aim) {
            return -1;
        }
        return high;
    }

    public static void sort3Way(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int cur = low+1;
        int ls = low;
        int hi = high;
        int flag = arr[ls];
        while (cur <= hi) {
            if (arr[cur] > flag) {
                swap(arr, cur, hi--);//左移
            } else if (arr[cur] < flag) {
                swap(arr, cur++, ls++);//右移
            }else {
                cur++;
            }
        }
        sort3Way(arr, low, ls - 1);
        sort3Way(arr, hi + 1, high);
    }



}
