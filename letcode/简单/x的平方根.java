package 简单;

/**
 * 实现int sqrt(int x) 函数。
 *
 * 计算并返回x的平方根
 *由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class x的平方根 {
    public static void main(String[] args) {
        int x = 5;
        int num = mySqrt2(x);
        System.out.println("x的平方根："+num);
    }

    public static int mySqrt(int x) {
       if (x==0) {
           return 0;
       }
       if(x==1) {
           return  1;
       }
        for (int i=1; i<=x ;i++) {
            if (i*i >x) {
                return i-1;
            }
        }
        return  -1;
    }

    /*二分法实现*/
    public static int  mySqrt2(int x) {
        int l = 1;
        int r = x;
        int mid = (l + r) /2;
        while (l <= r) {                        // 1   5    1, 2
            if (mid == x/mid ) {                // mid 3      1
                return mid;
            }else if (mid > x/mid) {           // 3 , 1   1, 5
                r = mid -1 ;                  // r 2
            }else  {
                l = mid+1;                    //            l 2
            }
            mid = (l +r )/2;                  //mid 1
        }
        return mid;
    }

    /**
     * 牛顿迭代法  f(x)=x^2-t
     * @param x
     * @return
     */
    public static int mySqrt3(int x) {
        double t = (double)x;
        double x0 = x;
        x0 = x0/2+t/(2*x0);
        while(Math.abs(x0*x0-t)>0.00001)
            x0=x0/2+t/(2*x0);
        return (int)x0;//double 转int类型必须使用强制类型转化
    }

}
