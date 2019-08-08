package 简单;

/**
 *给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 *
 * 异或 操作 的是 数据 对应的二进制数
 */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int num = singleNumber(nums);
        System.out.println("只出现一次数字："+num);

    }


    /**
     * 思路：根据异或运算的特点，相同的数字经过异或运算后结果为0，
     * 除单独出现一次的数字外，其他数字都是出现两次的，
     * 那么这些数字经过异或运算后结果一定是0。
     * 而任何数字与0进行异或运算都是该数字本身。
     * 所以对数组所有元素进行异或运算，运算结果就是题目的答案。
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        if (nums != null && nums.length > 0) {
            for (int i=0; i< nums.length; i++) {
                result = result ^ nums[i];
            }
        }
        return  result;
    }
}
