package array;

import java.util.Arrays;

public class TriangleMaxPerimeter {
    public static void main(String[] args) {
        System.out.println(FindMaxPerimeter(new int[]{2, 3, 3, 6, 7}));
    }


    //三角形最大周长
    public static int FindMaxPerimeter(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }

        return 0;
    }
}
