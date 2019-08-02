package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通过filtering 创建一个字符串String的集合
 *  对原始字符串进行过滤
 *
 */
public class filtering的使用 {

    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();
        strlist.add("aaa");
        strlist.add("bb");
        strlist.add("cc");
        strlist.add("d");

        List<String> filtereds = strlist.stream().filter(x->x.length()>2)
                .collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n",
                strlist, filtereds);

    }
}
