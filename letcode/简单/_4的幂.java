package 简单;

/**

 给定一个整数 (32 位有符号整数)，
 请编写一个函数来判断它是否是 4 的幂次方。
 示例 1:

 输入: 16
 输出: true

 示例 2:

 输入: 5
 输出: false

 进阶：
 你能不使用循环或者递归来完成本题吗？
 */
public class _4的幂 {

    public static void main(String[] args) {

        int num = 16;
        boolean b = isPowerOfFour(num);
        if(b) {
            System.out.printf("是3的幂");
        }else {
            System.out.println("不是三的幂");
        }
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n < 4) return false;
        while (n % 4 == 0) {
            if (n == 4) return true;
            n = n / 4;
        }
        return false;
    }

    public static boolean isPowerOfFour2(int num ) {
        if (num <= 0)
            return false;
        //先判断是否是 2 的幂
        if ((num & num - 1) != 0)
            return false;
        //如果与运算之后是本身则是 4 的幂
        if ((num & 0x55555555) == num)
            return true;
        return false;
    }
}
