package 简单;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class 二叉树的遍历层次 {

    static  List<List<Integer>> retlist = new ArrayList<>();
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
        List<List<Integer>> list =   levelOrderBottom(p);
        for (List<Integer> l: list) {
            System.out.println(Arrays.asList(l));
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();//创建的队列用来存放结点，泛型注意是TreeNode
        q.add(root);
        while (!q.isEmpty()) {//队列为空说明已经遍历完所有元素，while语句用于循环每一个层次
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while (count >0){  //遍历当前层次的每一个结点，每一层次的Count代表了当前层次的结点数目
                TreeNode temp=q.peek();
                q.poll();       //遍历的每一个结点都需要将其弹出
                list.add(temp.val);
                if(temp.left!=null)q.add(temp.left);      //迭代操作，向左探索
                if(temp.right!=null)q.add(temp.right);
                count--;
            }
            retlist.add(list);
        }
        return retlist;
    }

}
