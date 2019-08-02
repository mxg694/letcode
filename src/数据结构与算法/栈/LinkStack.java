package 数据结构与算法.栈;

/**
 * 链表实现
 */
public class LinkStack {
    private LinkStack headNode;
    private Integer  data;
    private LinkStack next;

    public void setNext(LinkStack next) {
        this.next = next;
    }

    public LinkStack() {
        this.headNode = new LinkStack();
    }

    public void push(int data) {
        if (headNode == null) {
            headNode = new LinkStack();
        }else if(headNode.getData() == null) {
            headNode.setData(data);
        }else {
            LinkStack llnode = new LinkStack(data);
            llnode.setNext(headNode);
            headNode = llnode;
        }
    }

    public Integer top() {
        if (headNode == null) {
            return null;
        }else {
            return headNode.getData();
        }
    }

    public Integer pop() {
        if (headNode == null) {
            System.out.println("Stack Empty");
            return null;
        }
        Integer data  = headNode.getData();
        headNode = headNode.getNext();
        return data;
    }

    public boolean isEmpty() {
        return headNode ==null?true:false;
    }

    public void deleteStack() {
        headNode = null;
    }

    public LinkStack(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public LinkStack getNext() {
        return next;
    }

    public void setHeadNode(LinkStack headNode) {
        this.headNode = headNode;
    }
}
