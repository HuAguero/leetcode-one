package statistacs;

//不用sqrt函数，找出x的平方根的整数部分
public class SqrtIntPart {


    public static void main(String[] args) {

        System.out.println(binarySearch(25));
        System.out.println(binarySearch(24));

        System.out.println(newtonSqrt(24));
    }

    //二分法查找
    private static int binarySearch(int x) {
        int index = -1;
        int l = 0;
        int r = x;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                index = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return index;
    }

    //牛顿迭代
    public static int newtonSqrt(int x) {
        if (x == 0)
            return 0;
        return (int) sqrt(x, x);
    }

    private static double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }
    }


}
