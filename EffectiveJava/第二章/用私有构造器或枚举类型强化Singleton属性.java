package 第二章;

public class 用私有构造器或枚举类型强化Singleton属性 {

}

//构建 singeton 实例1
class Elvis {
    public static  final  Elvis instance = new Elvis();

    private Elvis(){

    }
    public  Elvis getInstance() {
        return instance;
    }
}

//构建 singeton instance
class Elvis2 {
    public static final Elvis2 instance = new Elvis2();

    private Elvis2(){

    }
    public static Elvis2 getInstance() {
        return instance;
    }
}

// 实现Single 的第三种方法
enum  Elvis3 {
    instance ;

}
