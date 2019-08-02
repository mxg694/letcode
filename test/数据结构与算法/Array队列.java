package 数据结构与算法;

public class Array队列 {

    private Long [] arr ;

    private int maxSize;

    //有效元素大小
    private int elems;

    //队头
    private int font ;

    //队尾
    private int end ;

    public Array队列(int maxSize) {
        this.maxSize = maxSize;
        elems = 0;
        font = 0;
        end = -1;
    }

    //插入数据
    public void insert(Long value) {
        arr[++end] = value;
        elems++;
    }

    /**
     * 移除数据
     * @param value
     * @return
     */
    public Long remove(Long value) {
        elems--;
        return  arr[font++];
    }

    /**
     * 是否为null
     * @return
     */
    public boolean isEmpty() {
        return (elems == 0);
    }

    public boolean isFull() {
        return (end == maxSize-1);
    }

    public Integer size() {
        return elems;
    }
}
