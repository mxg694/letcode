package 简单;

import org.apache.commons.lang3.StringUtils;

/**
 给定两个字符串 s 和 t，判断它们是否是同构的。
 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
 两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:
 输入: s = "egg", t = "add"
 输出: true

 示例 2:
 输入: s = "foo", t = "bar"
 输出: false

 示例 3:
 输入: s = "paper", t = "title"
 输出: true

 说明:
 你可以假设 s 和 t 具有相同的长度。

 */
public class 同构字符串 {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean f = isIsomorphic(s,t);
        if (f) {
            System.out.println("是同构");
        }else {
            System.out.println("不是同构");
        }

    }

    public static boolean isIsomorphic(String s, String t) {
        boolean flag = false;
        int count = 0;
        if (StringUtils.isNotBlank(s) && StringUtils.isNotBlank(t) && s.length() == t.length()) {
            int[] indexs = new int[s.length()];
            for (int i=0; i< s.length(); i++) {
                int stemp = s.indexOf( s.charAt(i));
                int ttemp = t.indexOf(t.charAt(i));
                if (stemp == ttemp) {
                    count ++;
                }
            }
            if (count == s.length()) {
                flag =true;
            }
        }

        return  flag;
    }
}
