package 简单;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 */
public class 路径总和 {

    public static void main(String[] args) {

    }

    /**
     * 这道题的题意包括了中间的的路径总和。所以不是一个递归可以搞定的，需要两个递归。
     * 外层递归，提供了每次都是root，里层递归来看从这个root开始有多少个加起来和是等于的。
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left  ==null && root.right == null) {
            if (root.val == sum) {
                return true;
            }
            return false;
        }
        boolean result = true;
        result = hasPathSum(root.left, sum-root.val);
        if (result == true) {
            return result;
        }
        result = hasPathSum(root.right, sum-root.val);
        if (result == true ) {
            return result;
        }
        return false;
    }
}
