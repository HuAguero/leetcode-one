package array;

//最长有序子数组长度
public class ArrayMaxSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 2, 3, 4, 3, 4, 5, 6, 7};
        System.out.println(findMaxSeq(nums));

    }

    //贪心算法
    public static int findMaxSeq(int[] nums) {
        int max = 0;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                start = i;
            } else
                max = Math.max(max, i - start + 1);
        }

        return max;
    }

}
