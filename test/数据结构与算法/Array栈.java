package 数据结构与算法;

public class Array栈 {

    private int maxSize;

    private Long[] arr ;

    private int top;

    public Array栈(int size) {
        maxSize = size;
        arr = new Long[maxSize];
        top = -1;
    }

    //压入数据
    public void push (Long value) {
        arr[++top] = value;
    }

    //弹出数据
    public Long pop() {
        return arr[top--];
    }

    //访问栈顶数据
    public Long peek() {
        return arr[top];
    }

    //栈是否为空
    public boolean isEmpty() {
        return (top==-1);
    }

    /**
     * 栈是否满了
     * @return
     */
    public boolean isFull() {
        return (top == maxSize-1 );
    }
}
