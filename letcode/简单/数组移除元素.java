package 简单;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 *不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *


 */
public class 数组移除元素 {

    public static void main(String[] args) {
        int[] arr = {3,3,2 };
        Integer val = 3;
        int ret = removeElement(arr,val);
        System.out.println(ret);
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        if (nums.length ==0 ) {
            return 0;
        }
        for (int i :nums) {
            if (i != val) {
                nums[index++] = i;
            }
        }

        return  index;
    }
}
