package 简单;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 * 使用递归
 *
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
  //      l1.insertInLinkedList(l1, new ListNode(2), 2);
        l1.insertInLinkedList(l1, new ListNode(3), 2);

        ListNode l2 = new ListNode(1);
 //       l2.insertInLinkedList(l2, new ListNode(3), 2);
        l2.insertInLinkedList(l2, new ListNode(4), 2);

//        System.out.println(l1.val);

       ListNode node =  mergeTwoLists(l1,l2);
        System.out.println(node);
    }

    public static ListNode  mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if(l1.val<=l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next,l2);
        }else  {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }
}

 class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public static int size(ListNode node) {
        int length =0;
        ListNode currentNode =node  ;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public  ListNode insertInLinkedList(ListNode headNode,ListNode nodeToInsert, int position){
        if(headNode == null) {  // 链表为null
            return nodeToInsert;
        }
        int size = size(headNode);
        if(position > size+1 || position <1) {
            System.out.println("position of Node to insert is invalid, the vailid inputs are 1 to "+ (size+1));
            return headNode;
        }

        if (position == 1) { //在链表开头插入
            nodeToInsert.setNext(headNode);
        }else {  //在链表中间或末尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position-1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;

    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
