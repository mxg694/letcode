package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 *      使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */
public class 四数之和 {

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> list = fourSum(nums, target);

        if (list !=null && list.size() >0) {
            System.out.println("四数之和");
            for(List<Integer> l : list) {
                System.out.println(Arrays.toString(l.toArray()));
            }
        }
    }

    /**
     *  解题思路类似 三数之和  最外面多一层for循环
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (nums==null || len<4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i =0;i <nums.length-3; i++) {
            if (i!=0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i]+nums[i+1] +nums[i+2] +nums[i+3] > target) {
                break;
            }
            //最大值小于目标值跳过此循环
            if (nums[i]+nums[len-1]+nums[len-2]+nums[len-3] <target) {
                continue;
            }

            for (int j=i+1; j<len-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                //最大值小于目标值跳过此循环
                if (nums[i]+ nums[j]+nums[j+1] +nums[j+2] >target) {
                    break;
                }

                int left = j+1;
                int right = len -1;
                while (left<right) {
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum ==  target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
    //                    left++;
                        right--;
                        while (left< right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }else if (sum< target){
                        left++;
                    }else {
                        right--;
                    }
                }

            }
        }


        return result;
    }

}
