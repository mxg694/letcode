package 第二章;

import org.junit.Test;

/**
 * 静态工厂方法 和23中设计模式 工厂模式不同
 */
public class 考虑使用静态工厂方法代替构造器 {

    //静态工厂方法
    public static HelloWorld getInstance(){
          return new HelloWorld();
    }

    @Test
    public void getHelloworld() {
        HelloWorldFactory factory = new HelloWorldFactory();
        HelloWorld h = factory.createHelloWorld();
    }

}

//工厂方法
 class HelloWorldFactory {
    public HelloWorld createHelloWorld(){
        return new HelloWorld();
    }
}

class HelloWorld {

}