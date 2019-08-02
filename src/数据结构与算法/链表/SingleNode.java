package 数据结构与算法.链表;

public class SingleNode {

    public static void main(String[] args) {
        SingleNode l1 = new SingleNode(1);
        l1.insertInLinkedList(l1, new SingleNode(2), 2);
        l1.insertInLinkedList(l1, new SingleNode(2),3);
        l1.insertInLinkedList(l1, new SingleNode(3),4);
        SingleNode l2 = l1;
        System.out.println("l1:"+l1);
        l2.deeteLinkedList(l2,2);
        l2.deeteLinkedList(l2,3);
        System.out.println("l12:"+ l2);
    }


    private  int data;
    private SingleNode next;

    public SingleNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    /**
     * 获取链表的大小
     * @param node
     * @return
     */
    public  int size(SingleNode node) {
        int length =0;
        SingleNode currentNode =node  ;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public SingleNode insertInLinkedList(SingleNode headNode,SingleNode nodeToInsert, int position){
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
            SingleNode previousNode = headNode;
            int count = 1;
            while (count < position-1) {
                previousNode = previousNode.getNext();
                count++;
            }
            SingleNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;

    }

    //删除单向链表中间的一个节点
   public SingleNode deleteModeFromLinkedList(SingleNode headNode, int position) {
        int size = size(headNode);
        if(position > size+1 || position <1) {
            System.out.println("position of Node to insert is invalid, the vailid inputs are 1 to "+ (size+1));
            return headNode;
        }

        if (position == 1) { //删除单向链表的表头节点
            SingleNode currentNode = headNode.getNext();
            headNode = null;
            return headNode;
        }else  { //删除中间或者表尾节点
            SingleNode previousNode = headNode;
            int count = 1;
            while (count < position) {
                previousNode = headNode.getNext();
                count ++;
            }
            SingleNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.next);
            currentNode = null;
        }
        return headNode;

    }

    //删除单向链表
    void deeteLinkedList(SingleNode head, int i) {
        SingleNode auxilaryNode, iterator = head;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
