package 简单;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，编写一个函数来检验他们是否相同
 *
 * 如果两个数在结构相同，并且节点具有相同的值，则认为它们是相同的
 *
 示例 1:

 输入:       1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 输出: true

 示例 2:

 输入:      1
 /           \
 2             2

 [1,2],     [1,null,2]

 输出: false


 */
public class 相同的树 {

    public static void main(String[] args) {

    }

    /*递归法*/
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if  ((p!=null && q ==null )||(q!=null && p == null) ) {
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    /*队列的方法*/
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);  //两个数的节点进队列
        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();  //出队列，如果队列头为null返回 null
            TreeNode s = queue.poll();
            if (f== null && s == null) {
                continue;
            }else if (f== null || s==null || f.val != s.val) {
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(s.right);
            queue.add(s.right);
        }
        return true ;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
