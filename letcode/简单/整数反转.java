package 简单;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 */
public class 整数反转 {

    public static void main(String[] args) {
        Integer num =-120;
        Integer ret = 0;
        if(num >0) {
            ret = reverseInteger(num);
        }else {
            num = Math.abs(num);
            ret =  0 - reverseInteger(num);
        }

        System.out.println(ret);
    }

    public static Integer reverseInteger(Integer num) {
        int rs = 0;
        while (num > 0) {
            rs *= 10;
            rs += num % 10;
            num /= 10;
        }
        return rs;
    }


}
