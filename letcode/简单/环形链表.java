package 简单;

/**
 *  给定一个链表，判断链表中是否有环。
 *
 *   为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *   如果 pos 是 -1，则在该链表中没有环。
 *
 *   示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */
public class 环形链表 {

    public static void main(String[] args) {

    }

    /**
     * 判断一个单链表是否是循环链表，可以采用快慢指针，
     * 追击相遇的方式来实现。算法的原理可以形象的比喻成“龟兔赛跑”。
     * 兔子的速度是乌龟的两倍，它们在一个环形的跑道上面赛跑。
     * 经过一段时间之后，兔子必定会超过乌龟一圈，然后相遇
     * 。我们循环一个单链表，如果这个单链表是循环链表，
     * 快指针和慢指针必然会在某个节点相遇。
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head ;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ) {
                return true;
            }
        }
       return false;
    }

}
