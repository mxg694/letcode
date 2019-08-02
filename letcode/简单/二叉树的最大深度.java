package 简单;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 *
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);   //根
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = null;
        p.left.right = null;
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(5);
        p.right.left.left = new TreeNode(6);
        p.right.left.right = new TreeNode(7);

        int  i = maxDepth(p);
        System.out.println("二叉树最大深度："+i);
    }

    /**
     * 只要递归遍历一直到此树的叶子结点，最后只要从叶子结点开始一直向根结点回溯并+1，
     * 结果就是回溯经过的路径长度+1.
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nleft = maxDepth(root.left);
        int nright = maxDepth(root.right);;
        return nleft > nright ? nleft + 1 : nright + 1;
    }



}
