package 简单;

/**
 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长
 （长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 字符串的一个子序列是原始字符串删除一些（也可以不删除）
 字符而不改变剩余字符相对位置形成的新字符串。
 （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

 示例 1:
 s = "abc", t = "ahbgdc"
 返回 true.

 示例 2:
 s = "ahbgdc", t = "ahbgdc"
 返回 false.

 后续挑战 :

 如果有大量输入的 S，称作S1, S2, ... , Sk
 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 在这种情况下，你会怎样改变代码？
 */
public class 判断子序列 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence(s,t);
        if (b) {
            System.out.println("是子序列");
        }else {
            System.out.println("不是子序列");
        }

    }

    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int[] arr = new int[s.length()];
        int num = 0;
        if (s.length()<t.length() ) {
            for (int i=0;i<s.length(); i++) {
                int n = t.indexOf(s.charAt(i));
                if (n<0) {
                    return false;
                }
                t.substring(n,n+1);
                arr[i] = n;
            }
            if (arr !=null && arr.length >0) {
                for (int i=0;i<arr.length-1;i++) {
                    if (arr[i]<=arr[i+1]) {
                        num++;
                    }
                }
                if (num== arr.length-1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        char []c = s.toCharArray();
        for(char i:c){
            index = t.indexOf(i,index+1);
            if(index == -1) return false;
        }
        return true;
    }

}
