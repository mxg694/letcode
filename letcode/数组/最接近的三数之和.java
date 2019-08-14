package 数组;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int  num = threeSumClosest(nums, target);

        System.out.println("最接近的三数之和：" + num);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int clost = Integer.MAX_VALUE,sub = 0,abssub = 0,sum = 0; // 定义最接近的数,目前差值
        for(int i = 1 ; i < nums.length - 1 ; i++){
            int left = 0, right = nums.length - 1;
            while(left < i && right > i){

                sub = nums[left] + nums[right] + nums[i] - target;
                abssub = Math.abs(sub);

                if(clost > abssub){
                    clost = abssub;
                    sum = nums[left] + nums[right] + nums[i] ;
                }
                if(sub > 0){   //  sub >三数之和 大于 target
                    right--;
                } else if(sub < 0 ){  //三数之和小于 target 
                    left++;
                } else{
                    sum = nums[left] + nums[right] + nums[i] ;
                    break;
                }
            }
        }
        return sum;

    }

}
