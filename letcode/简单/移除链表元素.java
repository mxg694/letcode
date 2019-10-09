package 简单;

/**

 删除链表中等于给定值 val 的所有节点。

 示例:

 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5


 */
public class 移除链表元素 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        System.out.println(head);
    }

    public  static ListNode removeElements(ListNode head, int val) {

        if (head != null) {

        }

        return null;
    }
}
