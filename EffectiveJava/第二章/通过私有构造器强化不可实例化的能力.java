package 第二章;

public class 通过私有构造器强化不可实例化的能力 {
}

class UtilityClass {
    private UtilityClass() {
        try {

        }catch ( AssertionError e) {  //保证该类在任何情况下都不会被实例化

        }
    }
}
