package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class lambda {
    static List<User> userList = new ArrayList<>();
    static List<Integer> idList = new ArrayList<>();
    @Before
    public void  赋值() {

        User user1 = new User(1,"1",1);
        User user2 = new User(2,"2",2);
        User user3 = new User(3,"3",3);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        idList.add(1);
    }

    @Test
    public void 测试list循环(){
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void list赋值list() {
        List<String> strlist = new ArrayList<>();
        strlist = userList.stream().map(user -> {
            return user.getName();
            }).collect(Collectors.toList());
        strlist.forEach(n-> System.out.println(n));
    }


    @Test
    public void 两个list的差集() {
      List<User> list =   userList.stream().filter(item ->!idList.contains(item.getId())).collect(Collectors.toList());
        System.out.println("得到两个list 的差集：");
      list.forEach(n-> System.out.println(n));
    }


}




class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}