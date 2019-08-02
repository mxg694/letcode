package 简单;

/**
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 *给定有序数组: [-10,-3,0,5,9],
 *
 *一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class 将有序数组转换为二叉树 {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode t=  sortedArrayToBST(nums, 0,nums.length-1);
        System.out.println(t);

    }

    /**
     * 思路:采用二分法来创建平衡二叉树，根结点刚好为数组中间的节点，
     * 根节点的左子树的根是数组左边部分的中间节点，
     * 根节点的右子树是数据右边部分的中间节点；
     * 代码执行结果和示例给出结果不同，但满足平衡二叉树。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums,int left, int right) {
        if(left>right)return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid -1);
        root.right = sortedArrayToBST(nums,mid+1, right);

        return  root;
    }

}
