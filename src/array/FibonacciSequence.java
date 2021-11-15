package array;

public class FibonacciSequence {
    public static void main(String[] args) {

        System.out.println(calculate(18));

        System.out.println(calculate1(18));
        System.out.println(calculate2(18));
    }


    //暴力递归 2的n次方
    public static int calculate(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        return calculate(num - 1) + calculate(num - 2);
    }

    //去重递归 N 均为
    public static int calculate1(int num) {
        int[] arr = new int[num + 1];

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        if (arr[num] != 0) {
            return arr[num];
        }

        arr[num] = recurse(arr, num - 1) + recurse(arr, num - 2);
        return arr[num];
    }

    //双指针迭代 T O(n); S O(1)
    public static int calculate2(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        int low = 0;
        int high = 1;
        int sum = 0;
        for (int i = 2; i <= num; i++) {
            sum = low + high;
            low = high;
            high = sum;
        }
        return sum;
    }
}
