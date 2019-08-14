package 第一章;

/**
 *        欧几里德算法
 * 计算两个非负整数 a 和 b的最大公约数：
 * 若 a 是 0，则最大公约数为 b。
 * 否则，将 a 除以 b 得到余数 r，
 * a 和 b 的最大公约数即为 b 和 r 的最大公约数。
 */
public class 最大公约数 {

    public static void main(String[] args) {

    }

    public static int gcd (int a, int b) {

        if (a ==0 ) {
            return  b;
        }
        int r = a%b;
        return gcd(b, r);
    }

}
