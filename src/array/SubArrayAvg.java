package array;

//获取子数组平均值的最大值，子数组长度k，数组中连续k个数就是子数组
public class SubArrayAvg {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 23, -5, -6, 50, 4};
        System.out.println(findMaxAverage(nums, 4));
    }

    //滑动窗口
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        //先统计第一个窗口
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }

        return 1.0 * max / k;
    }
}
