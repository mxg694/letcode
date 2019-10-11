package 简单;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 给定一个非空数组，返回此数组中第三大的数。如果不存在，
 则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

 示例 1:
 输入: [3, 2, 1]
 输出: 1

 解释: 第三大的数是 1.
 示例 2:

 输入: [1, 2]
 输出: 2
 解释: 第三大的数不存在, 所以返回最大的数 2 .

 示例 3:
 输入: [2, 2, 3, 1]
 输出: 1

 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 存在两个值为2的数，它们都排第二。

。
 */
public class 第三大的数 {
    public static void main(String[] args) {
        int[] nums= {1,2};
        int n = thirdMax(nums);
        System.out.println("第三大的数："+n);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums != null && nums.length >0) {
           for (int i=0; i< nums.length;i++) {
               set.add(Integer.valueOf(nums[i]));
           }
           if (set.size()==1) {
               return nums[0];
           }else if (set.size() <3) {
               int max= 0;
               for (Integer i: set) {
                   max = i>max?i:max;
               }
               return max;
           }else {
               List<Integer> list = new ArrayList<>(set);
               Collections.sort(list);
               return list.get(list.size()-3);
           }
        }
        return 0;
    }

    public static Integer thirdmax2(int[] n) {
        Integer maxOne = null;
        Integer maxTwo = null;
        Integer maxThree = null;
        for(Integer i:n){
            if(i.equals(maxOne) || i.equals(maxTwo) || i.equals(maxThree)){
                continue;
            }
            if(maxOne == null || i > maxOne){
                maxThree = maxTwo;
                maxTwo = maxOne;
                maxOne = i;
            }else if(maxTwo == null || i > maxTwo){
                maxThree = maxTwo;
                maxTwo = i;
            }else if(maxThree == null || i > maxThree){
                maxThree = i;
            }
        }
        return maxThree != null ? maxThree: maxOne;

    }
}
