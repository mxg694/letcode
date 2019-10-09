package 第四章_类和接口;

import java.util.Date;

public class 第17条 {

    public static void main(String[] args) {
       /* Sub sub = new Sub();
        sub.overrideMe();*/

        Super s = new Sub();
        s.overrideMe();
    }

}

class Super {
    public Super() {
       // overrideMe();
    }

    public void overrideMe() {

    }
}

final class Sub extends Super {
    private Date date =null ;

    Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }


}