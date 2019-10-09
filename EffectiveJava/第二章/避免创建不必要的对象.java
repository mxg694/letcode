package 第二章;

import org.junit.Test;

import java.util.Date;

public class 避免创建不必要的对象 {


    /**
     * 自动装箱和拆箱的性能比较
     *
     *
     */
    @Test
    public static void add() {
        // 如果该为 long  性能会更好
        Long sum = 0L;      //程序大约构建了2^31个Long类型的实例对象
        for (int i = 0; i < Integer.MAX_VALUE ; i++) {
            sum +=i;
        }
        System.out.println("sun:"+sum);
    }

    @Test
    public void a() {
        //每次只需都创建一个新的String 实例
        String s = new String("aaa"); //do not do this

        String s1 = "aaa";
    }
}

// 反例  重用已知不会被修改的可变对象
class  person {
    private Date date = null;

    // do not do this
    public boolean isbabyBoomer(){
        Date p =  new Date("2019-01-01");   //p的值是固定的某些数据
        return  p.after(date);
    }
}

class C_person {
    private Date date = null;

    private static final Date d;

    static {
        d = new Date("2019-01-01");
    }

    public boolean isbabyBoomer() {
        return  d.after(date);
    }

}


