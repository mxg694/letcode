package 简单;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量
 *
 *示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 *  阶乘： n!=1×2×3×...×n。阶乘亦可以递归方式定义：0!=1，n!=(n-1)!×n。
 *
 */
public class 阶乘后的零 {

    public static void main(String[] args) {
        int n  = 25;
        int ret = trailingZeroes(n);
        System.out.println("阶乘后的零的个数：" + ret );
    }

    public static int trailingZeroes(int n) {
        int sum=0;
        while(n>0){
            sum+=n/5;
            n/=5;
        }
        return sum;

    }

}
