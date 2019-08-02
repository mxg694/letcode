package 简单;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class 最大子序和 {
    public static void main(String[] args) {
        int[] arr = {1,-3,4,-1};
        int sum = maxSubArray3(arr);
        System.out.println("最大子序和："+sum);
    }

    /**
     * 求解思路：暴力枚举所有的可能性，得出最后的结果
     *  时间复杂度为O(n^3)
     * 相当糟糕的一种解题思路，只能用于参考，没有实用价值
     */
    public static int maxSubArray1(int[] nums) {
        int maxSum = 0;

        for (int i= 0; i<nums.length; i++) {
            for (int j =i; j<nums.length; j++) {
                int tempSum = 0;
                for (int k = i; k<=j; k++) {
                    tempSum +=nums[k];
                }
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 求解思路：稍稍看一眼暴力求解的思路没，就会发现，用k去逐个标记其实是一个多余的做法
     * 所以，在此进行修改代码，减少一个for循环
     * 时间复杂度：O(n^2)
     * 这个算法比暴力求解稍微好了点儿，但是依然效率糟糕，没有实用价值
     */
    public static int maxSubArray2(int[] a) {
        int maxSum = 0;
        for (int i=0; i<a.length; i++) {
            int tempSum = 0;
            for (int j =i; j<a.length; j++) {
                tempSum +=a[j];
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }
        return maxSum;
    }
    /**
     * 求解思路：在算法一和算法二中，我们一直在用两个变量来标识遍历数组
     *  j代表当前序列的重点，i代表当前序列的起点
     *  如果我们只是单纯的想知道最大连续子序列的和，而不想知道最佳连续子序列的起点和终点的话
     *  那么这个i是完全可以被优化掉的
     * 时间复杂度：O(N)
     * 这个算法就是我们经常采用的算法之一，但是有遗憾的是没办法标识最佳连续子序列的位置
     */
    public static int maxSubArray3(int[] a) {
       int maxSum = 0;
       int tempSum = 0;
    
       for (int i =0; i<a.length; i++) {
           tempSum +=a[i];
           if (tempSum > maxSum) {
               maxSum = tempSum;
           }else {
               tempSum = 0;
           }
       }
       return maxSum;
    }

}
