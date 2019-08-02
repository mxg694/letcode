package lambda;

import java.util.ArrayList;
import java.util.List;

public class 使用Lambda表达式和函数接口 {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("c++");
        languages.add("Scala");

        languages.stream().filter(
                (name)->(name.startsWith("j")) ).forEach((name)->{
            System.out.println(name + " ");
        });
    }
}
