public class 顺序表之链表 {

    public static void main(String[] args) {
        顺序表之链表 l = new 顺序表之链表();
        l.add(0,0);
        l.add(1,1);
        l.add(2,2);
        l.add(3,3);
    }


    public Node head;

    public boolean isEmpty() {
        return this.head == null;
    }


    public int length() {
        Node p = head;
        int len = 0;
        if (p !=null) {
            while (p !=null) {
                len++;
                p = head.next;
            }
        }
        return len;
    }

    public Object get(int index) {
        int len = length();
        Node p = head;
        if (index <0 || index > len) {
            return new RuntimeException("查找的下标不对");
        }
        if (p !=null ) {
            int count = 0;
            while (p !=null && count < index) {
                count ++;
                p=p.next;
            }
        }

        if(p !=null) {
            return p.getData();
        }
        return null;
    }

    /**
     *
     * @param index  下标从0开始
     * @param o
     * @return
     */
    public Object set(int index, Object o) {

        if(head !=null && index >=0  && o != null) {
            Node p = head;
            int count = 0;
            while (p !=null && count < index) {
                count++;
                p =p.getNext();
            }
            if (p !=null) {
                Object data = p.getData();
                p.setData(o);
                return  data;
            }
        }
        return  null;
    }

    /**
     * 根据下标 添加节点
     * 1.在头部插入
     * 2.在尾部插入
     * 3.在中间插入
     * @param index  下标从0 开始
     * @param o
     */
    public boolean  add(int index, Object o) {
        if (o == null) {
            return false;
        }
        //在头部插入
        if (head == null || index <1) {
            this.head = new Node(o,head);
        }else  {
            //在中间或者尾部插入
            int count = 0;
            Node p = head;
            //找到要插入节点位置的前一个节点
            while (p.next !=null && count < index-1) {
                p = p.getNext();
                count ++;
            }
            //在尾部添加和中间插入属于同中情况
            p.next= new Node(o, p.next);

        }
        return  true;
    }
     /**
     * 根据索引删除节点
     * @param index
     * @return
     */
    public  Object remove(int index) {
        Object old = null;
        if (head!=null && index >= 0) {
            if (index == 0) {
                old = head.data;
                head = head.next;
            }else  {
                Node p = head;
                int count = 0;
                //找到要插入节点位置的前一个节点
                while (p.next !=null && count < index-1) {
                    p = p.next;
                    count++;
                }
                Node t = p.next;
                if (t != null) {
                    old =t.getData();
                    p.next = t.next;
                    t = null;
                }
            }
        }
        return old;
    }

    public void  clear() {
        head = null;
    }

    @Override
    public String toString() {
        return "顺序表之链表{" +
                "head=" + head +
                '}';
    }
}
