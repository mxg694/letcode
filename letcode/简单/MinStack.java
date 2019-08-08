package 简单;

import java.util.Stack;

/**
 * 设计一个支持push pop top 操作的，并可以在常数时间内检索到最小元素的栈
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 *MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 */
public class MinStack {

    //声明数据栈
    private static Stack<Integer> elementsStack=new Stack<Integer>();
    //声明辅助栈
    private static Stack<Integer> supportStack=new Stack<Integer>();

    private static int min = 0;
    /**
     * 考虑到时间复杂度的需求，添加一个辅助栈，
     * 每次入栈时将元素分别存入数据栈和辅助栈，
     * 辅助栈中的数据始终保持最小值在栈顶，需要获取最小值时，直接Peek()辅助栈即可。
     */
    public static void main(String[] args) {
        MinStack minStack=new MinStack();

        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        for ( Integer s :supportStack) {
            System.out.print(   s + " "  );
        }
        System.out.println();
        System.out.println(minStack.getMin());
        minStack.pop();
        for ( Integer s :supportStack) {
            System.out.print(   s + " "  );
        }
        System.out.println();
        System.out.println(minStack.getMin());
    }

    public MinStack() {

    }

    public static void push(int x) {
        if (supportStack.empty()) {
            supportStack.push(x);
            min = x;
        } else {
            if (x<=min){   //此处必须为<=,否则可以试一下{0，1，0}的情况
                supportStack.push(min);
                min = x;
            }
            supportStack.push(x);
        }
        elementsStack.push(x);
    }

    public static void pop() {
        //更新赋值栈
        if (elementsStack.peek().equals(supportStack.peek())) {
            supportStack.pop();
        }
        elementsStack.pop();
    }

    public static int top() {
        return elementsStack.peek();
    }

    public static int getMin() {
        //辅助栈
        return supportStack.peek();
    }

}
