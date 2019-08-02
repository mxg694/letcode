package 简单;

/**
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * eg:
 *
 * 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class 回文数 {
    public static void main(String[] args) {
        isPalindrome(123421);
    }
    //方案1  利用整数反转的方法
    public static void isPalindrome(Integer num ) {
        Integer ret = 整数反转.reverseInteger(num);
        if(ret.toString().equals(num.toString())) {
            System.out.println( num +":是回文数");
        }else {
            System.out.println( num +":不是回文数");
        }
    }

    //利用数组
    public static void  isPalindrome_two(Integer num) {

    }

    //利用字符串
    public static void  isPalindrome_three() {

    }
}
