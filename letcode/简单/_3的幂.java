package 简单;

/**
 给定一个整数，写一个函数来判断它是否是 3 的幂次方。

 示例 1
 输入: 27
 输出: true

 示例 2:
 输入: 0
 输出: false

 示例 3:
 输入: 9
 输出: true

 示例 4:
 输入: 45
 输出: false

 进阶：
 你能不使用循环或者递归来完成本题吗？

 */
public class _3的幂 {

    public static void main(String[] args) {

        int num = 441;
        boolean b = isPowerOfThree(num);
        if(b) {
            System.out.printf("是3的幂");
        }else {
            System.out.println("不是三的幂");
        }
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n < 3) return false;
        while (n % 3 == 0) {
            if (n == 3) return true;
            n = n / 3;
        }
        return false;
    }

}
