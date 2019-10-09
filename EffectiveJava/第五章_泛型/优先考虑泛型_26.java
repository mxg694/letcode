package 第五章_泛型;

import org.omg.CORBA.Object;

import java.util.Arrays;

public class 优先考虑泛型_26 {

}

//未使用泛型
class Stack {
    private Object[] eles;
    private int size = 0;
    private static final int DEFAULT_VALUE = 16;

    public Stack() {
        eles = new Object[DEFAULT_VALUE];
    }

    public void push(Object e) {
        ensureCApacity();
        eles[size++] = e;
    }

    public Object pop(){
        if (size ==0) {
            throw  new RuntimeException();
        }
        Object r = eles[--size];
        eles[size] = null;
        return r;
    }



    private void ensureCApacity() {
        if (eles.length == size) {
            eles = Arrays.copyOf(eles,2*size+1);
        }
    }
}
//使用泛型
class Stack1<E> {
    private E[] eles;
    private int size = 0;
    private static final int DEFAULT_VALUE = 16;

    public Stack1() {
     //   eles = new E[DEFAULT_VALUE];
        eles = (E[]) new Object[DEFAULT_VALUE];
    }

    public void push(E e) {
        ensureCApacity();
        eles[size++] = e;
    }

    public E pop(){
        if (size ==0) {
            throw  new RuntimeException();
        }
        E r = eles[--size];
        eles[size] = null;
        return r;
    }



    private void ensureCApacity() {
        if (eles.length == size) {
            eles = Arrays.copyOf(eles,2*size+1);
        }
    }
}