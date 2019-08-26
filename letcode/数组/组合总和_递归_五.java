package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。

 示例 1:

 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]

 示例 2:

 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]

 */
public class 组合总和_递归_五 {

    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> list = combinationSum(nums, target);
        System.out.println("组合总数：");

        if( list != null && list.size()>0) {
            for (List<Integer> l: list) {
                System.out.println(Arrays.toString(l.toArray()) );
            }
        }else {
            System.out.println("无匹配");
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        if(candidates.length ==0 || candidates[0]>target)
            return list;
        List<Integer> tmp = new ArrayList<Integer>();
        helper(candidates, target, 0, tmp, list);
        return list;
    }

    public static void helper(int[] a, int target, int start, List<Integer> tmp, List<List<Integer>> res){
        if (target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(tmp));
            //res.add(tmp);//得到的是空结果,因为tmp仅仅是一个指针
            return;
        }
        for(int i=start; i<a.length; i++){
            tmp.add(a[i]);
            //target = target -a[i];不新建int出错
            //helper(a, target, i, tmp, res);
            int newtarget = target -a[i];
            helper(a, newtarget, i, tmp, res);
            tmp.remove(tmp.size()-1 );
            if(newtarget <= 0)
                break;
        }
    }


}
