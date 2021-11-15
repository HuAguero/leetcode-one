package array;


/*
一个有序数组nums，原地删除重复出现的元素，使得每个元素只出现一次，返回删除后数据的新长度。
不能使用额外的数据空间，必须原地修改输入数组并在使用O(1)额外空间的条件下进行
 */
public class DeleteDuplicate {

    //双指针算法
    public static int removeDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7};
        int length = removeDuplicate(nums);
        System.out.println(length);
    }
}
