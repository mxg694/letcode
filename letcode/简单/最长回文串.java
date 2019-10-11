package 简单;

/**
 给定一个包含大写字母和小写字母的字符串，
 找到通过这些字母构造成的最长的回文串。
 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:
 输入:
 "abccccdd"
 输出:
 7

 解释:
 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。


 */
public class 最长回文串 {
    public static void main(String[] args) {
        String s = "abccccdd";
        int n = longestPalindrome(s);
        System.out.println("最长回文串："+n);
    }

    /**
     * 所出现的字符有多少是单个的，有多少是双的
     *
     * 如果是双的 +2  单个的所有数量 为1
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int sum = 0;
        int single = 0;
        if (s !="" && s.length() >0) {
           while ( s != "" && s.length() >0) {
               int n = 0;
               String sc = s.substring(0,1);
               while (s!=""&& s.indexOf(sc)>=0 ) {
                  s = s.replaceFirst(sc,"");
                  n++;
               }
               if (n >=1 && n %2 ==1) {
                    sum += n-1;
                    single = 1;
               }else {
                   sum+=n;
               }
           }
            return sum +single;
        }
        return 0;
    }
}
