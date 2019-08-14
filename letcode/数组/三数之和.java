package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum2(nums);

        if (list !=null && list.size() >0) {
            System.out.println("三数之和");
            for(List<Integer> l : list) {
                System.out.println(Arrays.toString(l.toArray()));
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0; i< nums.length-2; i++) {
            int temp = nums[i];
            for (int j=i+1; j< nums.length-1; j++) {
                int tempj = nums[j];
                for (int m =j+1; m< nums.length; m++) {
                    if (temp+tempj+nums[m] == 0) {
                        List<Integer> l = new ArrayList<>();
                        l.add(temp);
                        l.add(tempj);
                        l.add(nums[m]);
                        boolean flag = false;
                        if (list !=null && list.size()>0) {
                            for (List<Integer> tl : list) {
                                if (tl.contains(temp) && tl.contains(tempj) && tl.contains(nums[m])){
                                    flag = true;
                                    continue;
                                }
                            }
                           if (!flag) {
                               list.add(l);
                           }
                            flag = false;
                        }else {
                            list.add(l);
                        }
                    }
                }
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null){
            return null;
        }
        //如果数组长度小于3，返回一个空集合
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();

        for (int  i=0;i < nums.length; i++) {
            int j = i+1;
            //k从数组最后一个数（最大的数）往前跑
            int k = nums.length-1;
            while (j < k) {
               if (nums[i]+nums[j]+nums[k] == 0) {
                   List<Integer> list = new ArrayList<>();
                   list.add(nums[i]);
                   list.add(nums[j]);
                   list.add(nums[k]);
                   set.add(list);
                   //当有重复的数字出现时，j往前跑，防止结果有重复
                   while(j < k && nums[j] == nums[j + 1]){
                       j++;
                   }
                   while(j < k && nums[k] == nums[k - 1]){
                       k--;
                   }
                   j++;
                   k--;
               }else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
               }else  {
                   k--;
               }
            }
        }
        return  new ArrayList<>(set);
    }
}
