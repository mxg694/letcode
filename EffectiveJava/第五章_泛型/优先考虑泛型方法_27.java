package 第五章_泛型;

import org.junit.Test;

import java.util.*;

public class 优先考虑泛型方法_27 {

    //方法 参数 类型不安全
    public static Set union( Set s1 ,Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    //建议：
    public static <E> Set<E> union1 (Set<E>s1,Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    //泛型静态工厂
    public static <K,V>HashMap<K,V> newHashMap() {
        return new HashMap<K,V>();
    }

    @Test
    public void test(){
        Map<String, List<String>> map = newHashMap();
    }
}
