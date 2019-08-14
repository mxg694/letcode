package 简单;

/**
 *  给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 *  1 -> 寻找两个有序数组的中位数
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "寻找两个有序数组的中位数"
 *
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
public class Excel表列名称 {

    static  String s = "";

    public static void main(String[] args) {
        String  t = convertToTitle(701);
        System.out.println("exacel表列名称"+t);
    }

    /**
     * 这道题比较简单，类似于10进制转2进制。循环除26即可。
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        while (n !=0) {
            int temp = (n-1) %26;
            s =  (char)('A' +temp )+ s;
            n = (n-1) / 26;
        }

        return s;
    }

}
