package array;

public class LemonChange {
    public static void main(String[] args) {
        System.out.println(change(new int[]{5, 10, 5, 20}));
    }

    //贪心算法，柠檬水找零
    public static boolean change(int[] walls) {
        if (walls == null || walls.length == 0)
            return false;

        int five = 0;
        int ten = 0;

        for (int wall : walls) {
            if (wall == 5) {
                five++;
            } else if (wall == 10) {
                if (five == 0) {
                    return false;
                } else {
                    five--;
                    ten++;
                }
            } else if (wall == 20) {
                if (five > 0 && ten > 0) {//先进行局部最优解，五元是通用的，先换掉10
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
