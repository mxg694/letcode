package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class 理解 {

    @Test
    public void 计算机核心处理器数量() {
        out.println( "计算机核心处理器数量:"+ Runtime.getRuntime().availableProcessors());
    }

    @Test
    public void 测试list遍历删除() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ac");
        list.add("ad");
        for (String s:list) {
            if (s.equals("ac")) {
                list.remove(s);
            }
        }
        for (int i=0; i<list.size(); i++) {
            out.println(list.get(i));
        }
    }

    /**
     * Long 值 == 判断 127 -》true   128->false
     */
    @Test
    public void  判断long值相等() {

        Long l1 = 128L;
        Long l2 = 128L;
        out.println(l1==l2);
    }

    @Test
    public void 测试二维数组() {
        int[][]  arr = {{5,7,9},{12,14,16,18},{23,25,36,47},{22,54,65,15},{22,34}}; ;
        System.out.println(arr[4][0]);
    }

}
