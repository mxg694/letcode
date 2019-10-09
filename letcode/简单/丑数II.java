package 简单;

import java.util.ArrayList;
import java.util.List;

/**
 编写一个程序，找出第 n 个丑数。
 丑数就是只包含质因数 2, 3, 5 的正整数。

 示例:
 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

 说明:
 1 是丑数。
 n 不超过1690。

 */
public class 丑数II {

    public static void main(String[] args) {
        int n = 10;
        int temp = nthUglyNumber2(n);
        System.out.println("丑数II："+ temp);
    }

    public static int nthUglyNumber(int n) {

        if (n ==0) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);

        if( 0< n && n < 1690 ) {
            for (int i=2; i<Integer.MAX_VALUE; i++) {
                if(list.size() > n) {
                    break;
                }
                if(丑数.isUgly(i)) {
                    list.add(i);
                }
            }
        }

        return list.get(n-1);
    }

    /**
     * ：动态规划思想。后面的丑数一定是由前面的丑数乘以2、3或5得到。
     * 所以第n个丑数一定是由前n-1个数中的某3个丑数（分别记为index2、index3、index5）
     * 分别乘以2、3或者5得到的数中的最小数，index2，index3，index5有个特点，
     * 即分别乘以2、3、5得到的数一定含有比第n-1个丑数大
     * （可利用反证法：否则第n-1个丑数就是它们当中的一个）
     * 最小丑数，即第n个丑数由u[index2]*2、u[index3]*3、u[index5]*5中的最小数得出。
     * 让它们分别和第n个丑数比较，若和第n个丑数相等，则更新它们的值。
     * 注：一次最少更新一个值（如遇到第n个丑数是6时，index2和index3都要更新）。
     *
     */
    public static int nthUglyNumber2(int n) {
        if(n<= 0) {
            throw new RuntimeException();
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int k = 1;
        while (k<n) {
           list.add( min(list.get(index2)*2,list.get(index3)*3, list.get(index5)*5) );
            if (list.get(index2)*2 == list.get(k)) {
                index2++;
            }
            if (list.get(index3)*3 == list.get(k)) {
                index3++;
            }
            if(list.get(index5)*5 == list.get(k)) {
                index5++;
            }
            k++;
        }
        return list.get(k-1);
    }

    public static int min(int a, int b,int c) {
        return a>b?(b<c?b:c):(a<c?a:c);
    }

}
