package 数组;

import java.util.Arrays;

/**

 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]

 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]

 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] arr = searchRange(nums, target);
        System.out.println("元素在数组中重复出现的位置" +Arrays.toString(arr));

    }

    /**
     * 使用二分法 去
     * @param nums
     * @param target
     * @return
     */
    public static   int[] searchRange(int[] nums, int target) {
        int[] arr = {-1,-1};
        int l = 0;
        int r = nums.length-1;
        int mid = (l+r)/2;
        int p = -1;
        while (l<=r) {
            if (nums[mid] > target) {
                r = mid -1;
            }else if(nums[mid] < target) {
                l = mid +1;
            }else {
                p = mid;
                break;
            }
            mid = (l+r)/2;
        }
        if (p != -1) {
            int a = p, b = p;
            while (a > 0 && nums[a - 1] == target) {
                a--;
            }
            arr[0] =a;
            while (b < nums.length - 1 && nums[b + 1] == target) {
                b++;
            }
            arr[1] = b;
        }
        return arr;
    }

}
