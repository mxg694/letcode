package 简单;

import java.util.Arrays;
import java.util.List;

/**
 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1:

 输入: "hello"
 输出: "holle"

 示例 2:

 输入: "leetcode"
 输出: "leotcede"

 说明:
 元音字母不包含字母"y"。

 */
public class 反转字符串中的元音字母 {

    public static void main(String[] args) {
        String str = "hello";
        String a = reverseVowels(str);
        System.out.println("反转字符串中的元音字母："+a );
    }

    public static String reverseVowels(String s) {
        if (s != null && s.length() >0) ;
        Character[] chars = {'a','A','e','E','i','I','o','O','u','U'};
        List<Character> list = Arrays.asList(chars);
        char[] strs= s.toCharArray();
        int l = 0;
        boolean lflag =false;
        boolean rflag = false;
        int r= s.length()-1;
        while (l< r) {
            if (  !lflag && list.contains(strs[l])) {
                lflag = true;

            }
            if ( !rflag && list.contains(strs[r])) {
                rflag =true;
            }
            if (lflag && rflag && l< r) {
                lflag = false;
                rflag = false;
                Character t = null;
                t = strs[l];
                strs[l] = strs[r];
                strs[r] = t;
                l++;
                r--;
            }else {
                if (!lflag) {
                    l++;
                }
                if (!rflag) {
                    r--;
                }
            }
        }

        return new String(strs);
    }
}
