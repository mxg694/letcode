package 数组.困难;

/**
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 说明:

 假设你总是可以到达数组的最后一个位置。

 */
public class 跳跃游戏ii {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int num = jump(nums);
        System.out.println("跳跃游戏ii："+num);
    }

    public static int  jump(int[] nums) {
        int num = 0;
        int len = nums.length;
        if( nums !=null && nums.length >0) {
            int tem = 0;
            while ( tem < len ) {
                tem +=nums[num++];
            }
        }
        return num;
    }

}
