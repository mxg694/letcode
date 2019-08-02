package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class 复杂的结合Predicate {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("c++");
        names.add("Scala");

        Predicate<String> startsWithJ = (n) -> n.startsWith("j");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println(n) );
    }
}
