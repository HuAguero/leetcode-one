package array;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

//数据中找出两个数 之和等于 target 并返回下标数组
public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solution(nums, 10)));
        System.out.println(Arrays.toString(solution1(nums, 10)));
    }

    //暴力解法 O(n平方)
    private static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }


    private static int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }


}