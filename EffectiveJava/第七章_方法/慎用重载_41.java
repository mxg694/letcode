package 第七章_方法;

import java.util.*;

public class 慎用重载_41 {

    public static void main(String[] args) {
        father[] ss= {
                new father(), new son(), new grandson()
        };
        for (father f: ss) {
            System.out.println(f.name());
        }
    }
}

class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "set";
    }
    public static String classify(List<?> s) {
        return "list";
    }
    public static String classify(Collection<?> s) {
        return "Unknown";
    }

    // 整合签名三个
    public static String classify(Collection<?> c, boolean b) {
        return c instanceof Set?"set": c instanceof List?"list":"Unknown";
    }

    public static void main(String[] args) {

        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> c: collections) {
            System.out.println(classify(c));//Unknown   Unknown Unknown


        }
    }
}

class father{
    String name() {
        return "father";
    }
}

class son extends father {
    String name() {
        return "son";
    }
}

class grandson extends son {
    @Override
    String name() {
        return "grandson";
    }
}