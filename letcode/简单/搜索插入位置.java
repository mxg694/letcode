package 简单;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[]arr = {1,3,5,6};
        int target = 4;
        int index = searchInsertTwo(arr, target);
        System.out.println("搜索插入位置："+index);
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;

        if (nums.length == 0) {
            index = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return index;
    }

    //算法类实现
    public static int searchInsertTwo(int[] nums, int target) {
        int mid ;
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            mid = lo + (hi-lo) /2;
            if (nums[mid] == target) {
                return mid;
            }else  if (nums[mid] < target) {  //中间值小于目标值
                lo = mid +1;
            }else {
                hi = mid-1;
            }
        }
        return lo;
    }


}
