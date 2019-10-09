package 动态规划;


import org.apache.commons.lang3.StringUtils;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babbad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class 最长回文子串__ {

    public static void main(String[] args) {
        String str = "babbad";
        String s = longestPalindrome(str);
        System.out.println("最长回文子串" + s);
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int start = 0;
        int maxlen = 0;
        if (StringUtils.isNotBlank(s)) {
            int len = s.length();
            boolean[][] flags = new boolean[1000][1000];

            for (int i=0; i<len; i++) {
                flags[i][i] = true;
                if (maxlen ==0 || maxlen == 1) {
                    start = i;
                    maxlen = 1;
                }
                //相邻的两个字符相同
                if (i<len-1 && s.charAt(i) == s.charAt(i+1) ) {
                    flags[i][i+1] = true;
                    start = i;
                    maxlen = 2;
                }

            }
            //m代表回文子串长度，从3开始
            for(int m = 3; m <= len; m++){
                for(int i = 0; i <= len-m; i++ ){
                    //依次比较是否符合状态转移方程
                    int j = i+m-1;
                    if(flags[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                        flags[i][j] = true;
                        start = i;
                        maxlen = m;
                    }
                }
            }
        }

        return s.substring(start, start+maxlen);
    }

    /**
     * 回文中心的两侧互为镜像。因此，回文可以从它的中心展开
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
