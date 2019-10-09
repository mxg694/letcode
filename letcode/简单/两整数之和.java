package 简单;

/**
 * 不使用运算符 + 和 - ​，计算两整数 ​​a 、b 之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class 两整数之和 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = getSum(a,b);
        System.out.println("两数之和：" +sum);
    }

    public static int getSum(int a, int b) {
//        String stra = Integer.toBinaryString(a);
//        String strb = Integer.toBinaryString(b);
        if (b == 0) return a;
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        return getSum   (sum, carry);
    }
}
