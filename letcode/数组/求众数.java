package 数组;

import java.util.Arrays;

/**
 *给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class 求众数 {

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        int num = majorityElement2(arr) ;
        System.out.println("求众数："+ num);
    }

    /**
     *    双层for循环
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int  num = -1;
        int tindex = 0;
        for(int i=0; i< nums.length; i++) {
            int temp = nums[i];
            for (int j= i; j< nums.length; j++) {
                if (temp == nums[j]) {
                    tindex++;
                }
            }
            if (tindex > (nums.length/2)) {
                num = temp;
            }else {
                tindex = 0;
            }
         }

        return num;
    }


    /**
     * 先排序，然后去计算众数
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int num = -1;
        int tindex = 1;
        int temp = nums[0];
        for (int i =1;i < nums.length; i++  ) {
            if (temp != nums[i]) {
                temp = nums[i];
                tindex = 1;
            }else {
                tindex++;
                if (tindex > (nums.length /2)) {
                    return temp;
                }
            }
        }

        return num;
    }

}
