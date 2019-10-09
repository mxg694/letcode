package 简单;

/**
 *

 输入: [1,2,3,1]
 输出: 4
 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 偷窃到的最高金额 = 1 + 3 = 4 。

 示例 2:

 输入: [2,7,9,3,1]
 输出: 12
 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 *
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int rob = rob2(nums);
        System.out.println("打家劫舍：" + rob);
    }
    public static int rob(int[] nums) {
        if (nums != null && nums.length >0) {
            int size = nums.length;
            int ji = 0;
            int ou = 0;
            for (int i=0; i< size; i++) {
                if (i % 2 ==0) {
                    ou += nums[i];
                }else {
                    ji += nums[i];
                }
            }
            return Math.max(ji,ou);
        }

        return 0;
    }

    /**
     * 思路(动态规划)：
     * 1、使用动态规划求解，偷窃前n号房屋的金额为n-2号房屋的金额+本次 与 n-1号房屋的金额取最大值
     * 2、递推方程为f(n) = Max(f(n-1), f(n-2)+nums[n])
     * 3、因为递推时只需要前两个结果，所以简化为维护两个状态值即可
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int first = 0;
        int second = 0;
        int rob = 0;

        int len = nums.length;
        for (int i=0; i<len; i++) {
            int ji = first + nums[i];
            rob = Math.max( ji,second );
            first = second;
            second = rob;
        }

        return rob;
    }


}
