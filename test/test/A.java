package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {

    public static void main(String[] args) {
      String arr = "aa,aaa";
        List<String> list1 = Arrays.asList(arr.split(","));
        List<String> list2 = new ArrayList<>();

        list2.add("aa");
        list2.add("aaa");
        list1.removeAll(list2);
        System.out.println("移除数据" + list1.size());
    }

}
