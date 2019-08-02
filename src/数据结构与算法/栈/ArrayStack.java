package 数据结构与算法.栈;

/**
 * 栈的数组实现
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public ArrayStack () {
        capacity = 1;
        array = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isStackFull() {
        return (top==capacity-1) ;
    }

    public void push(int data) {
        if(isStackFull()) {
            System.out.println("Stack OverFlow");
        }else  {
            array[++top] = data;
        }
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return  -1;
        }

        return array[top--];
    }

    public void deleteStack() {
        top = -1;
    }

}
