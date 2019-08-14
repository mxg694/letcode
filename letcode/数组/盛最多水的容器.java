package 数组;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        int[] nums = { 1,8,6,2,5,4,8,3,7};
        int max = maxArea2(nums);

        System.out.println("盛水最多的容器:" + max);

    }

    /**
     *  暴力枚举
     * 思路： 双重for 循环实现
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i =0; i< height.length; i++) {
            int tempi = height[i];
            for (int j = i+1; j< height.length; j++) {
                int t = height[i]>height[j]?height[j]:height[i];
                if (t*(j-i) >max) {
                    max = t*(j-i);
                }
            }
        }
        return max;
    }

    /**
     *方法2：
     *
     * 时间：O(n)
     * 空间：O(1)
     *
     * 不需要两层for循环，从两端往中间靠近进行了
     */
    public static int maxArea2(int[] height) {
        int max_res = 0;
        int l = 0,r = height.length-1;
        while (l<r) {
            max_res = Math.max(max_res,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return max_res;
    }
}
