package 第五章_泛型;

import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

/**
 PECS ： producer-extends   consumer-supper

 public static <E> void swap(List<E> list, int i, int j)  无限制的类型参数
 public static  void swap(List<？> list, int i, int j)  无限制的通配符

 如果方法调用， 无限制通配符会优先 无限制参数类型使用
 */
public class 利用有限制性通配符提升api的灵活性_28 {
}

class stack<E>{
    public stack(){

    }
    public void push(E e){

    }
    public E pop(){
        return null;
    }

    public boolean isempty() {
        return false;
    }

    public void pushAll(Iterable<E> src ) {
        for (E e: src) {
            push(e);
        }
    }
    // ？extends E : ？代表的类型是 E的子类型
    public void pushAll2(Iterable<? extends  E> src ) {
        for (E e: src) {
            push(e);
        }
    }


    public void popAll(Collection< E> dst) {
        dst.add(pop());
    }
    // ？super E : ？代表的类型是 E的父类型
    public void popAll2(Collection<? super E> dst) {
            dst.add(pop());

    }

    @Test
    public void test() {
        stack<Number> s = new stack<>();
        Iterable<Integer> ie = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };
//      s.pushAll(ie); //有问题 类型不匹配 s的类型是Number  ie的类型是 Integer
        s.pushAll2(ie);  //类型转换是可以的

        Collection<Object> objs = new Collection(){

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }
        };

  //     s.popAll(objs);  有问题 类型不匹配 s的类型是Number  objs的类型是 Object
        s.popAll2(objs); // 类型可以匹配
    }
}
