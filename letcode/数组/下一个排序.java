package 数组;

import java.util.Arrays;

/**

 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 字典序：
 对于数字1、2、3…n的排列，不同排列的先后关系是从左到右逐个比较对应的数字的先后来决定的。
 例如对于5个数字的排列 12354和12345，排列12345在前，排列12354在后。
 按照这样的规定，5个数字的所有的排列中最前面的是12345，最后面的是 54321。


 暂时不太懂   待更深理解

 */
public class 下一个排序 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] arr = nextPermutation(nums);
        System.out.println("下一个排序："+ Arrays.toString(arr));
    }

    public static int[] nextPermutation(int[] nums) {
        int i= nums.length-1;

        while (i>0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if (i>0) {
            int j = nums.length-1;
            while (j>=0 && nums[j] <=nums[i-1] ) {
                j--;
            }
            swap(nums,i-1, j);
        }
        reverse(nums, i);

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i) {

        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
