package 基础例子;

/**
 * 写一个递归，实现1+3+5+7+9+11......
 */
public class 简单递归 {

    public static void main(String[] args) {
        int n = f(10);
        System.out.println(n);
    }


    public static Integer f(int n) {
        if(1==n ) {
            return 1;
        }
        if (n ==0) {
            return  0;
        }
        return n+f(n-2);
    }
}
