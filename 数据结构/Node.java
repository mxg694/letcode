public class  Node {
    public static void main(String[] args) {
        顺序表之链表 l = new 顺序表之链表();
        l.head = new Node(0);
        l.add(1,1);
        l.add(2,2);
        l.add(3,3);
        l.add(4,4);
        l.remove(2);
        System.out.println(l);
    }




    Object data;
    Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}