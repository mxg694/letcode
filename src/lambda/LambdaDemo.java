package lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试  Lambda  使用()->{}  LambdaDemo
 */
public class LambdaDemo {

    public static void main(String[] args) {
//        test_ori();
//        test_java8();

      test_copy();

 //       test_summary();

        listTomap();
    }

    @Test
    public static void test_ori() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before java8 ");
            }
        }).start();
    }

    public static void test_java8() {
        new Thread(()->{
            System.out.println("In java8");
        }).start();
    }

    /*通过复制不同的值创建一个子列表
    * 可以使用distinct() 方法过滤集合中的复合元素
    * */
    public static  void  test_copy(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i->i*i)
                .distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates :%s %n"
                , numbers, distinct);
    }

    //计算 List 中元素的最大值，最小值 综合和平均值
    public static void test_summary() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }

    //list 转Map
    public static void listTomap() {
        List<User> list = new ArrayList<>();
        User u1 = new User(1,"a");
        User u2 = new User(1,"b");
        User u3 = new User(2,"c");

        list.add(u1);
        list.add(u2);
        list.add(u3);

        //   (key1, key2) -> key1  保证map 如果key重复 报错问题
        Map<Integer,String> map = list.stream().collect(
                Collectors.toMap(User::getId, User::getName ,(key1, key2) -> key1));

        map.forEach((key,value)->{
            System.out.println("key:"+key +",   value: "+value);
        } );
    }


}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}