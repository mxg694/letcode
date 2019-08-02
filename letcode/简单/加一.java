package 简单;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加 一
 * 最高位数字存放在首位，数组中的每个元素只能存放一个数字
 * <p>
 * 这个整数不会以0开头
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class 加一 {

    public static void main(String[] args) {
        int[] arr = {9};
        int[] num = plusOne(arr);
        System.out.println("数组转int：" + Arrays.toString(num));


    }

    /**
     * 思路一： 把数组变成  一个对应数字   数字加1后  变成数组
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int num = arrayToInt(digits);
        num += 1;
        return intToArray(num);
    }

    public static int arrayToInt(int[] arr) {
        int ret = 0;
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                ret = ret + arr[i];
                if (i != arr.length - 1) {
                    ret *= 10;
                }

            }
        }
        return ret;
    }

    public static int[] intToArray(int num) {
        String str = String.valueOf(num);
        int[] intarr = null;
        if (StringUtils.isNotBlank(str)) {
            String[] starr = str.split("");
            intarr = new int[starr.length];
            for (int i = 0; i < starr.length; i++) {
                intarr[i] = Integer.valueOf(starr[i]);
            }
        }
        return intarr;
    }

    public static int[] plusOne_2(int[] digits) {
        for (int i =digits.length-1; i>=0 ;i --) {
            //非9 +1
            if (digits[i] <= 9) {
                digits[i]++;
                return digits;
            }
            //逢9 置 0
            digits[i] = 0;
        }
        //全是9
        int[] reult = new int[digits.length +1];
        reult[0] = 1;
        return reult;
    }
}
