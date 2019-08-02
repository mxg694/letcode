package 简单;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 平衡二叉树
 *     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 *    示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4

 */
public class 平衡二叉树 {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root)==-1?false:true;
    }
    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        if(left == -1){
            return -1;
        }
        int right = maxDepth(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(right-left)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }


}
