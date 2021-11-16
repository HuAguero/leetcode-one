package array;

//n个硬币，摆成接替形状，第k行正好k个
public class ArrayCoins {
    public static void main(String[] args) {

        System.out.println(FindRow(5050));
        System.out.println(FindRow1(5050));
        System.out.println(FindRow2(5050));
    }

    //等差数列公式
    public static int FindRow(int sn) {
        return (int) ((-1.0 + Math.sqrt(1.0 + 8.0 * sn)) / 2.0);
    }

    public static int FindRow1(int sn) {
        if (sn <= 0)
            return 0;

        for (int i = 1; i <= sn; i++) {
            sn = sn - i;
            if (sn < i) {
                return i;
            }
        }
        return 0;
    }

    //牛顿迭代
    public static int FindRow2(int sn) {
        if (sn <= 0)
            return 0;

        return (int) sqrt(sn, sn);
    }

    public static double sqrt(double x, double n) {
        double res = (x + (2 * n - x) / x) / 2;
        if (res == x) {
            return res;
        } else {
            return sqrt(res, n);
        }

    }
}


