package 简单;

import java.util.*;

/**
 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]

 示例 2:

 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [9,4]

 */
public class 两个数组的交集 {

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] nums = intersection(num1,num2);
        System.out.println("两个数组的交集："+ Arrays.toString(nums));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int[] rets = null;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (nums1 != null && nums1.length>0 && nums2 !=null && nums2.length>0) {
            for (int i=0;i<nums1.length; i++) {
                list1.add(nums1[i]);
            }
            for (int i=0;i<nums2.length; i++) {
                list2.add(nums2[i]);
            }
            list1.retainAll(list2);
        }
        if (list1 != null && list1.size()>0) {
            for (int i=0;i<list1.size(); i++) {
                set.add(list1.get(i));
            }
            rets = new int[set.size()];
            Object[] objs = set.toArray();
            for (int i=0;i< objs.length;i++) {
                rets[i] = Integer.parseInt(objs[i].toString());
            }
        }

        return  rets;
    }

}

