package 简单;
/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

 */
public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s ="loveleetcode";
        int num = firstUniqChar(s);
        System.out.println("第一个唯一字符串的索引："+num);
    }

    public static int firstUniqChar(String s) {
        if (s !="" && s.length()>0) {
            for (int i=0;i<s.length();i++ ) {
                int f = s.indexOf(s.charAt(i));
                int e = s.lastIndexOf(s.charAt(i));
                if (f==e) {
                    return i;
                }
            }
        }

        return  -1;
    }
}
