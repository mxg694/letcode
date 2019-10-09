package 简单;

/**
 给定一个整数数组，判断是否存在重复元素。

 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 示例 1:

 输入: [1,2,3,1]
 输出: true

 示例 2:

 输入: [1,2,3,4]
 输出: false

 示例 3:

 输入: [1,1,1,3,3,4,3,2,4,2]
 输出: true

 */
public class 存在重复元素 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean flag = containsDuplicate(nums);
        if (flag) {
            System.out.println("存在重复元素");
        }else {
            System.out.println("不存在重复元素");
        }
    }

    /**
     *使用计数排序的思想，创建一个新数组来计数
     * 这个方法按道理，时间复杂度和set是一样的，还要遍历两次，但是之所以快，
     * 可能是hashset内部操作虽然是O(1),但是有几部操作，反而比计数排序每位总共只做三个操作慢
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        if (nums != null && nums.length > 0 ){
            int min = nums[0];
            int max = nums[0];
            for (int  i=0 ;i< nums.length; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            int  d = max - min;
            int[] arr = new int[d+1];
            for (int  i=0; i< nums.length; i++) {
                arr[nums[i]-min]++;
                if (arr[nums[i] - min ] == 2) {
                    return true;
                }
            }

        }

        return false;

    }

    /**
     * 暴力枚举法
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        boolean flag = false;
        if (nums != null && nums.length > 0 ){

        }

        return false;

    }
}
