package Jvm;
//运行时 jvm 把 堆栈方法区交互  的信息放入方法区
public class 堆栈方法区交互 {
    //main方法本身放入方法区
    public static void main(String[] args) {
        //test1是引用，所以放入到栈区里，Simple自定义对象应该放到堆里面
        Sample test1 = new Sample("测试1");

        test1.pringName();

    }
}

//运行时 jvm 把 Sample  的信息放入方法区
class  Sample {
    //new Simple 实例后，name引用放到栈区里，name对象放入堆里
    private String name;

    public Sample(String name) {
        this.name = name;
    }
    //printName 方法本身 放入 方法区里
    public void pringName() {
        System.out.println(name);
    }
}