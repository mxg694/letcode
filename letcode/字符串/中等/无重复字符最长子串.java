package 字符串.中等;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串


 */
public class 无重复字符最长子串 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        int num = lengthOfLongestSubstring(str);
        System.out.println("无重复最长子串：" + num);

    }

    /**
     *滑动窗口
     * 既然是模式串匹配，那么肯定是要有优化的滑动窗口的。
     * 在匹配中我们遇到重复字符，不能i+1，比如目前窗口是[i，j)，在j位匹配到重复字符，
     * 我们已经知道在在[i，j-1]窗口内是没有重复字符的，而在j位就存在了重复字符，
     * 重复的位置在s位，那么我们再去匹配[i+1，i+1+1]到[i+1，j]是没有意义的，
     * 因为一定会有重复字符，而且长度会小于之前的长度。
     * 所以我们直接将窗口滑到匹配到的重复字符s的位置。即新窗口为[s+1，s+1)；
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxmatch = 0;
        if (StringUtils.isNotBlank(s)) {
            int len = s.length();
            Map<Character,Integer> map = new HashMap<>();
            for (int i=0, j =0; j <len; j++) {
                //如果存在重复字符，将窗口滑到重复字符的地方
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                maxmatch = Math.max(maxmatch, j-i+1);
                map.put(s.charAt(j), j+1);
            }
        }

        return maxmatch;
    }

    /**
     *  暴力枚举  双重for
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int num = 0;

        return num;
    }
}
