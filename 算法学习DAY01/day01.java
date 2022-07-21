import java.util.*;

public class day01 {
    public static void main(String[] args) {
        towNum(new int[] { 1, 2, 3, 3, 3, 2, 2, 1 });
    }

    /**
     * 数组中两个数出现了奇数次，其他所有数都出现了偶数次
     * 打印这两个数
     * 
     * @param arr
     */
    public static void towNum(int... arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1);
        int ret1 = 0;
        for (int i : arr) {
            if ((rightOne & i) == 1) {
                ret1 ^= i;
            }
        }
        int ret2 = ret1 ^ eor;
        System.out.println(ret1 + "  " + ret2);
    }
}