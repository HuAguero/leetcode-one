package array;

import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] num2 = new int[]{2, 4, 6, 8};


        //System.out.println(Arrays.toString(merge(num1,5,num2,4)));
        System.out.println(Arrays.toString(merge1(num1, 5, num2, 4)));
    }

    //原理，时间复杂度比较高
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }


    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[nums1.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < newNums.length; i++) {
            if (nums1[j] < nums2[k]) {
                newNums[i] = nums1[j];
                j++;
            } else {
                newNums[i] = nums2[k];
                k++;
            }

            if (j == m)
                break;

            if (k == n)
                break;
        }

        if (j < m) {
            System.arraycopy(nums1, j, newNums, j + k, m + n - j - k);
        }

        if (k < n) {
            System.arraycopy(nums2, k, newNums, j + k, m + n - j - k);
        }

        return newNums;
    }
}
