package 简单;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例:
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
。
 */
public class 找不同 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        char c = findTheDifference(s,t);
        System.out.println("找不同："+c);
    }

    public static char findTheDifference(String s, String t) {
        char r = '0';
        int[] arr = new int[26];
        char[] ss = s.toCharArray();
        char[] st = t.toCharArray();
        for (char temp: ss) {
            arr[temp-'a'] ++;
        }
        for (char temp: st) {
            int k= --arr[temp-'a'];
            if (k ==-1) {
                r = temp;
            }
        }

        return r;
    }
}
