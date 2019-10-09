package 简单;

/**
 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，
 则返回 True，否则返回 False。

 说明：不要使用任何内置的库函数，如  sqrt。

 示例 1：
 输入：16
 输出：True

 示例 2：
 输入：14
 输出：False


 */
public class 有效的完全平方数 {
    public static void main(String[] args) {
        int num = 100;
        boolean f = isPerfectSquare(num);
        if (f) {
            System.out.println("是有效的完全平方数");
        }else {
            System.out.println("不是有效的完全平方数");
        }
    }

    public static boolean isPerfectSquare(int num) {
       if (num ==1) {
           return true;
       }
       if (num  > 0 ) {
          int l = 0;
          int r = num;
          while (l<= r) {
              int mid = (l+r)/2;
              long middle = l+(r-l)/2;

              System.out.println(mid + ", " + middle);
              if (mid*mid >num) {
                  r= mid-1;
              }else if(mid*mid< num) {
                  l= mid+1;
              }else {
                  return true;
              }

          }
       }
       return false;
    }

    /**
     * 数学归纳法:举例每个平方数1，4，9，16，25，36，49，64，81，100两个之间相差是n个基数的和，
     * 即1，3，5，7，9，11，13，15等等。通过这样的方法减去每个差，看这个数等不等于0，就能得出结论了。
     * @param num
     * @return
     */
    public boolean isPerfectSquare3(int num) {
        for(int i = 1; num > 0; i += 2){
            num -= i;
        }
        return num == 0;
    }

}
