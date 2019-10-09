package 简单;

/**
 给定一个数组 nums，编写一个函数将所有 0
 移动到数组的末尾，同时保持非零元素的相对顺序。
 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]

 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。

 */
public class 移动零 {

    public static void main(String[] args) {
     //   int[] nums = {0,1,0,3,12};
        int[] nums = {2,1};
        moveZeroes(nums);
        for (int i=0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void moveZeroes(int[] nums) {
        if (nums != null && nums.length >0) {
            int t = 0;
            int temp =0;
            int length = 0;
            for (int i=0; i< nums.length;i++) {

                if(nums[i] ==0) {
                    length++;
                    t = i;
                }else {
                    if(nums[t] ==0) {
                        temp = nums[t];
                        nums[t] =nums[i];
                        nums[i] =temp ;
                        t= i;
                    }
                }
                if (length >1) {
                    t= t+1-length;
                }
            }
        }
    }

}
