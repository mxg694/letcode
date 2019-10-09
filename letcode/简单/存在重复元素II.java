package 简单;

import java.util.HashSet;
import java.util.Set;

/**

 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

 示例 1:

 输入: nums = [1,2,3,1], k = 3
 输出: true

 示例 2:

 输入: nums = [1,0,1,1], k = 1
 输出: true

 示例 3:

 输入: nums = [1,2,3,1,2,3], k = 2
 输出: false

 *
 */
public class 存在重复元素II {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 1;
        boolean flag = containsNearbyDuplicate(nums,k);

        if(flag) {
            System.out.println("存在重复元素II");
        }else  {
            System.out.println("不存在重复元素II");
        }
    }

    /**
     *  使用hashset  或者 HashMap
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        int min = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        if(nums != null && nums.length >0) {
            for (int i =0; i< nums.length; i++) {
                if (set.contains(nums[i])) {
                   for (int j=0; j<i; j++) {
                       if (nums[i] == nums[j]) {
                           min = j;
                       }
                       max = i;
                   }
                }
                set.add(nums[i]);
            }
        }
        if(max - min == k) {
            flag = true;
        }

        return flag;
    }

    /**
     * 暴力枚举
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean flag = false;


        return flag;
    }
}
