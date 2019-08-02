package 啊哈算法;

/**
 *
 */
public class 暴力枚举 {

    public static void main(String[] args) {

        int a,b,c,m,i,sum = 0; //sum是用来计数的，因为需要初始化为0
        m = 18;
        //开始枚举a 和b
        for (a=0 ; a< 1111; a++) {
            for(b = 0 ; b< 1111 ; b++) {
                c = a+ b ;  //计算出 c
                //当a使用的火柴棍根数 + b + c 之和 等于 m-4时，则成功求出一组解
                if(fun(a) + fun(b) + fun(c) == m-4 ) {
                    System.out.println(a +"+" +b +"="+c);
                    sum ++ ;
                }
            }
        }
        System.out.println("一共可以拼出"+sum+"个不同的等式");
    }

    public static int fun(int x ) {
        int num = 0 ; //用来计数的变量
        int[] f = {6,2,5,5,4,5,6,3,7,6} ; //用一个数组来记录0-9 每个数字需要的火柴数量

        while (x/10 != 0) {  //说明至少有两位数
            num += f[x%10]; //获得x末尾数字并将次数所需要用到的火柴棍根数累加到num
            x = x/10; //去掉x的末尾数字
        }
        num += f[x]; // x 所需要用到的火柴棍的根数
        return  num ;
    }

}
