package 简单;

/**
 * 给定一个排序链表，删除所有重复元素，使得每个元素只出现一次
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.insertInLinkedList(l1, new ListNode(2), 2);
        l1.insertInLinkedList(l1, new ListNode(2),3);
        l1.insertInLinkedList(l1, new ListNode(3),4);
        l1.insertInLinkedList(l1, new ListNode(3),5);
        System.out.println(l1);


    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || null == head.next) {
            return head;
        }
        ListNode cur1 = head ;
        ListNode cur2 = head.next;
        while (null != cur2)  {
            if (cur1.val != cur2.val) {
                cur1 = cur2;
                cur2 = cur2.next;
            }else  {
                while (cur1.val == cur2.val) {
                    cur2 = cur2.next;
                    if (null == cur2 ) {
                        cur1.next = null;
                        return head;
                    }
                }
                cur1.next = cur2;
                cur1 = cur2;
                cur2 = cur2.next;
            }
        }

        return head;
    }


    public static ListNode deleteDuplicates2(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            }else  {
                p = p.next;
            }
            System.out.println("p:"+p);
            System.out.println("head:" +head);
        }
        return  head;
    }

}
