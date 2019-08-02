package 数据结构与算法.队列;

public class ArrayQueue {

    private int  front;
    private int rear;
    private int capacity;
    private int[] array;

    private ArrayQueue(int size) {
        capacity = size;
        front = -1;
        rear = -1;
        array = new int[size];
    }

    public static ArrayQueue createQueue(int size) {
        return new ArrayQueue(size);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear+1)%capacity ==front);
    }

    public int  getQueueSize() {
        return ((capacity-front+rear+1)%capacity);
    }

    public void enQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }else {
            rear = (rear+1) %capacity;
            array[rear] =data;
            if (front == -1) {
                front=rear;
            }
        }
    }

    public Integer deQueue() {
        Integer data = null;
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }else {
            data = array[front];
            if (front==rear) {
                front = rear-1;
            }else {
                front=(front+1)%capacity;
            }
        }
        return data;
    }


    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        System.out.println(q.getQueueSize());
        System.out.println(q.front);
        q.deQueue();
        q.deQueue();
        System.out.println(q.getQueueSize());
        System.out.println(q.front);

    }
}
