package 第二章;

import java.util.Arrays;

public class 消除过期的对象引用 {
}

class stack{
    private Object[] eles ;
    private int size = 0;
    private static final int  default_capacity = 16;

    public stack() {
        eles = new Object[default_capacity];
    }

    public void push(Object e) {
        ensureCapacity();
        eles[size++] = e;
    }

    public Object errpr_pop() {
        if (size ==0) {
            throw new RuntimeException();
        }
        return eles[--size];
    }

    public Object correct_pop() {
        if (size ==0) {
            throw new RuntimeException();
        }
        Object result = eles[--size];
        eles[size] = null;  //防止内存泄漏
        return result;
    }


    public void ensureCapacity() {
        if (eles.length == size) {
            eles = Arrays.copyOf(eles,2*size+1);
        }
    }
}