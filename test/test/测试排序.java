package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 测试排序 {


    @Test
    public void test() {
        String a = "abc";
        String b = "abd";
        System.out.println(a.compareTo(b) );
    }






    @Test
    public void sort() {
        List<String> list = new ArrayList<>();
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/ca5d0d5a-0195-47e7-9240-abec5995de42/http-nio-8080-exec-442.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/3e83f9b2-044d-4bd4-83f9-c1413223be9a/http-nio-8080-exec-446.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/b46e7b96-71bb-412f-8e88-0c2ead468949/http-nio-8080-exec-445.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/811dc8d9-733a-40c2-a7df-89e35b56c9e7/http-nio-8080-exec-447.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/f00e2325-b883-45d7-a88e-26fda783f685/http-nio-8080-exec-441.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/a63b7f31-f37b-4ab4-96e2-45d5e7bfefe8/http-nio-8080-exec-443.jpg");
        list.add("https://static01.netclassroom.cn/ncrupload/exam/answercard/b0d0e1b6-565b-4d1f-9993-8ad1949a668a/http-nio-8080-exec-444.jpg");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               String t1 = o1.substring(o1.lastIndexOf("/"),o1.lastIndexOf(".") );
               String t2 = o2.substring(o1.lastIndexOf("/"),o2.lastIndexOf(".") );
               return  t1.compareTo(t2);
             }
        });


        for(String a: list) {
            System.out.println(a);
        }
    }
}
