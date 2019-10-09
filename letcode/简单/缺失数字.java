package 简单;

import java.util.Arrays;

/**

 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

 示例 1:

 输入: [3,0,1]
 输出: 2

 示例 2:

 输入: [9,6,4,2,3,5,7,0,1]
 输出: 8

 说明:
 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?


 */
public class 缺失数字 {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int num = missingNumber2(nums);
        System.out.println("缺失数字："+num);
    }


    public static int missingNumber(int[] nums) {
        int num = -1;
        if(nums != null && nums.length >1) {
            Arrays.sort(nums);
            for (int i =1; i<= nums.length -1; i++) {
                if(nums[i]-nums[i-1] != 1) {
                    num = nums[i-1]+ 1;
                }
            }
        }
        return num;
    }

    /**
     * 这个题有一个很直观的解法：求出0-n的和，然后求出数组所有数的和，两个和相减，得到结果。
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int num = -1;
        if(nums != null && nums.length >1) {
            int sum = 0;
            for (int elem : nums) {
                sum += elem;
            }
            return ((1 + nums.length) * nums.length / 2) - sum;
        }
        return num;
    }
}
