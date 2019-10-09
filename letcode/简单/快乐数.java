package 简单;

/**
 *
 编写一个算法来判断一个数是不是“快乐数”。

 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

 示例:

 输入: 19
 输出: true
 解释:
 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 */
public class 快乐数 {

    public static void main(String[] args) {
        int n = 19;
        boolean b = isHappy(n);
        if(b) {
            System.out.println("是快乐数");
        }else {
            System.out.println("不是快乐数");
        }
    }

    public static boolean isHappy(int n) {
        int sum = 0;

        while ( n !=0  ) {
            int mod = n %10;
            n = n /10;
            sum += Math.pow(mod,2);
        }
        if (sum ==1) {
            return true;
        }else {
          return  isHappy(sum);
        }

    }
}
