package sort;

import java.util.Scanner;

public class Meituan {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int i = 0;
        int[] num = new int[N];

        for (int j = 0; j <N ; j++) {
            num[i++] = scanner.nextInt();
        }

        System.out.println(getMaxArea(N, num));
    }

    public static int getMaxArea(int N, int[] num) {
        int max = 0;
        int lowest = 0;
        for (int i = 1; i < N; i++) {
            for (int j=0;j<i;j++) {
                lowest = getLowest(num, j, i);
                if (lowest*(i-j)>max) {
                    max = lowest * (i - j+1);
                }
            }
        }
        return max;
    }

    public static int getLowest(int[] arr, int low, int high) {
        int min = arr[low];
        for (int i = low; i < high; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


//    public static int getMaxPublic(String s1, String s2) {
//        int low1, low2, high1, high2;
//        int max = 0;
//
//    }
//
//    public
}
