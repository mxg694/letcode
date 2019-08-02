import java.util.Arrays;

public class 线性表 {

    public static void main(String[] args) throws Exception {
        线性表 l= new 线性表(10);
        l.insert(0,0);
        l.insert(1,1);
        l.insert(2,2);
        l.insert(3,3);
        l.insert(1,'c');

        l.remove(4);
        l.display();

    }

    private Object[] elems;
    private int currlen;


    public 线性表(int maxsize) {
        currlen = 0;
        elems= new Object[maxsize];
    }

    /**
     * 清空该线性表
     */
    public void clear() {
        currlen = 0;
    }

    /**
     *  获取当前线性表长度
     * @return
     */
    public int length() {
        return currlen;
    }

    /**
     *  在指定位置插入某个元素
     * @param i
     * @param o
     */
    public void  insert(int i, Object o) throws  Exception{
        //当前线性表是否是满的
        if( elems.length ==  currlen) {
            throw new RuntimeException("当前线性表已满");
        }
        //插入的位置是否正确
        if (i<0 || i > currlen) {
            throw new RuntimeException("插入位置失败");
        }
        //插入
        for (int t = currlen; t > i; t--) {
            elems[t] = elems[t-1];
        }
        elems[i] = o;
        currlen++;
    }

    /**
     * 根据下标获取元素
     * @param i
     * @return
     */
    public Object get(int i) {
        //插入的位置是否正确
        if (i<0 || i > currlen-1) {
            throw new RuntimeException("插入位置失败");
        }
        return elems[i];
    }

    /**
     * 移除
     * @param i
     */
    public void remove(int i) {
        //插入的位置是否正确
        if (i<0 || i > currlen) {
            throw new RuntimeException("位置不对");
        }
        for (int t=i; t<currlen; t++) {
            elems[t] =elems[t+1];
        }
        currlen--;
    }

    public int indexOf(Object o) {
        for (int i =0; i< currlen; i++ ) {
            if (o.equals(elems[i])) {
                return i;
            }
        }
        return  -1;
    }


    /**
     * 展示 改顺序表
     */
    public void  display() {
        for (int i = 0;i< currlen; i++) {
            System.out.print( elems[i] + "    " );
        }
    }

    @Override
    public String toString() {
        return "线性表{" +
                "elems=" + Arrays.toString(elems) +
                ", currlen=" + currlen +
                '}';
    }
}
