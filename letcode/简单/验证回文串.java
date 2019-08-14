package 简单;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "寻找两个有序数组的中位数 man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class 验证回文串 {

    public static void main(String[] args) {
        String s = "寻找两个有序数组的中位数 man, a plan, a canal: Panama";
        System.out.println("是否是回文串："+ isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        int i=0; int j = s.length()-1;
        s = s.toLowerCase();
        while (i<j) {
            if (!Character.isLetterOrDigit(s.charAt(i)) ) {  //当前字符 不是字母 不是数字
                i++ ;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return  true;
    }

}
