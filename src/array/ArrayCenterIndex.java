package array;

import java.util.Arrays;

//找到数组左边之和等于右边之和的中心下标
public class ArrayCenterIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 0, 3, 2, 1};
        System.out.println(findArrayCenterIndex(nums));
    }

    private static int findArrayCenterIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int sums = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (total == sums) {
                return i;
            } else {
                sums -= nums[i];
            }
        }

        return -1;
    }
}
