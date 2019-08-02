package 基础例子;

/**
 * 尾递归
 *    定义：在一个程序中，执行的最后一条语句是对自己的调用，而且没有别的运算
 *    实现： 是在编译器优化的条件下实现的
 *    编译器优化：
 *
 */
public class 斐波那契 {

    public static void main(String[] args) {
        int n = 4;
        int num =  fib3(n);
        int num1 = fib1(4);
        System.out.println("递归斐波那契：" +num1);
        System.out.println("斐波那契：" +num);
    }

    /**
     * 斐波那契数是一个典型的递归解决问题的模板，所以最简短的代码就是使用递归。
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n <= 1) {
            return n;
        }
        return fib(n-1) +fib(n-2);
    }


    public static int fib1(int n) {
       int res = f(1,1,n);
       return res;
    }

    public static int f(int first, int second, int n) {
        if (n ==0) {
            return 0;
        }
        if (n< 3) {
            return  1;
        }
        if (n == 3) {
            return first+second;
        }
        return f(second, first+second, n-1);
    }

    //采用循环结构去实现
    //采用两个辅助变量
    public static int fib3(int n) {
        if(n ==0) {
            return 0;
        }
        if(n ==1) {
            return 1;
        }
        int temp1 = 0;
        int temp2 = 1;
        int res = 0;
        for (int  i=2; i<=n; i++) {
            res =  temp1 + temp2;
            temp1 = temp2;
            temp2 = res;
        }
        return res;
    }

    //使用一个辅助变量
    public static int fib4 (int n){
        if (n==0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int temp = 0;
        int res = 1;

        for (int i =2 ;i <=n; i++){
            res += temp;
            temp = res- temp;
        }
        return res;
    }
    //使用辅助数组
    public  static int fib5(int  n) {
        int[] f = new int[n+1];
        f[0] = 0;
        if (n >0 ) {
            f[1] = 1;
        }
        for (int i =2 ; i<=n; i++) {
            f[i] = f[i-1] +f[i-2];
        }
        return f[n];
    }

}
