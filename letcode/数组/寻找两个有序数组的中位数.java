package 数组;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2
 *
 * 、请找出这两个有序数组的中位数，并且 要求算法的时间复杂度为 O(log(m + n))
 *
 *示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 *
 */
public class 寻找两个有序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2= {2,4};

        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println("寻找两个有序数组的中位数："+d );
    }

    /**
     * 解法1：比较容易想到的办法，由于对时间复杂都有一定的要求，空间换时间。
     * 新建一个新的数组，将两个数组有序插入到新的数组中。
     * 最终如果时奇数个的话直接返回新数字的中间数，
     * 偶数的话返回数组中间两个数的平均数。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        //记录nums1，nums2，nums的下标。
        int  index1 = 0,index2 =0 ,index = 0;
        int[] nums = new int[len1+len2];
        //将nums1，2有序插入到nums中
        while (index1<len1 && index2< len2 && index < nums.length ) {
            nums[index++] = nums1[index1]<nums2[index2]?nums1[index1++]:nums2[index2++];
        }
        //连个if用于其中一个数组插入完毕，剩余数组继续插入。
        if (index1 != len1) {
            while (index1< len1) {
                nums[index++] = nums1[index1++];
            }
        }
        if (index2 != len2) {
            while (index2< len2) {
                nums[index++] = nums2[index2++];
            }
        }

        //为奇数直接返回中间数，#注意，此时index并非数组下标，因为插入完毕后执行了index++，
        if (index %2 !=0) {
            return nums[index/2];
        }else  {
            return   ((double)(nums[index/2-1]+nums[index/2]))/2;
        }
    }

}
