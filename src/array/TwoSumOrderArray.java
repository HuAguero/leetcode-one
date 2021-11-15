package array;

import java.util.Arrays;

public class TwoSumOrderArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 8, 99};
        System.out.println(Arrays.toString(solution(nums, 11)));
        System.out.println(Arrays.toString(solution1(nums, 11)));
    }

    //二分法 N*LogN
    private static int[] solution(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;

        for (int i = 0; i < nums.length; i++) {
            int low = i;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[0];
    }

    //双指针 N
    private static int[] solution1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }

        return new int[0];
    }
}
