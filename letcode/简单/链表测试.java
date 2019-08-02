package 简单;

public class 链表测试 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.insertInLinkedList(l1, new ListNode(3), 2);
        l1.insertInLinkedList(l1, new ListNode(3), 3);
        l1.insertInLinkedList(l1, new ListNode(4), 4);
        ListNode l2 =l1;

        System.out.println("l1:"+l1);
        System.out.println("l2:"+l2);
    }


}
