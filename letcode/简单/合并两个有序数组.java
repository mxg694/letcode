package 简单;

import java.util.Arrays;

/**
 * 给定两个有序整数数组num1, num2,将num2合并到num1中
 * 是num1 成为一个有序数组
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class 合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums2.length,nums2,nums2.length);
        merge(nums2, nums1.length,nums2,nums2.length);
    }

    //归并排序的merge过程
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int index=m+n-1;
        while(index>=0){
            //前两个判断要放在前面，防止空指针异常
            if(i<0){
                nums1[index--]=nums2[j--];
            }else if(j<0){
                nums1[index--]=nums1[i--];
            }
            else if(nums1[i]>nums2[j] && i>=0){
                nums1[index--]=nums1[i--];
            }else if(nums1[i]<=nums2[j]&& j>=0){
                nums1[index--]=nums2[j--];
            }
        }
        System.out.println("合并两个有序数组：" + Arrays.toString(nums1));
    }


    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] num3 = new int[m+n];
        int a = 0;
        int b = 0;
        for (int i=0; i<num3.length; i++) {
            if (a<nums1.length && b< nums2.length) {
                if (nums1[a] > nums2[b]) { //两数组都未遍历完，相互比较后加入
                    num3[i] = nums2[b];
                    b++;
                }else  {
                    num3[i] = nums1[a];
                    a++;
                }
            }else  if (a< nums1.length) {//num2已经遍历完，无需比较，直接将剩余num1加入
                num3[i] = nums1[a];
                a++;
            }else if (b< nums2.length) {//num1已经遍历完，无需比较，直接将剩余num2加入
                num3[i] = nums2[b];
                b++;
            }
        }
        System.out.println("排序后："+ Arrays.toString(num3));
    }

}
