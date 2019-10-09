package 简单;

/**
 统计所有小于非负整数 n 的质数的数量。

 示例:

 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 */
public class 计质数器 {
    public static void main(String[] args) {
        int i= 10;
        int n = countPrimes2(i);
        System.out.println("计质数器：" + n );
    }

    public static int countPrimes(int n) {
        int sum = 0;
        if(  n >1) {
            for (int i=2 ;i<n; i++) {
                if( isPrimes(i) ) {
                    System.out.println(i);
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     * 判断一个数是不是质数
     * @param n
     * @return
     */
    public static boolean isPrimes(int n) {
        boolean flag = false;
        if (n >1) {
            int sum = 0;
            for (int i=2; i<=n/2; i++) {
                if (n % i ==0) {
                   sum ++;
                }
            }
            if (sum == 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     使用见埃拉托色尼筛法。
     好方法
     说的都是对循环条件的处理：
     如果要实现筛法，需要一个O(n)的数组来存储每一个数是不是素数，暂定为true，筛选，把不是素数的定为false，最终数组里为true的就是所有的素数了。如何筛选？p是素数，那么2p, 3p……一定不是素数。事实上，如果筛的是2p, 3p……那么考虑 2*3这个数，它被2筛了一次，又被3筛了一次，没有必要。可以这样筛选：对于每一个素数p，筛掉p^{2}, p^{2}+p, p^{2} + 2p……
     并不需要对[2, n]的每一个数进行筛选，只需要对[2, \sqrt{n}]进行筛选，即可筛出所有不是素数的数。

     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    //非质数的数其为下标对应的值为 真。
                    signs[j] = true;
                }
            }
        }
        return count;
    }


}
