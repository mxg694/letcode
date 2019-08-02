package 简单;

import org.apache.commons.lang3.StringUtils;

/**
 *  给定一个 haystack 字符串和一个 needle 字符串，
 *  在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 */
public class 实现strStr函数 {

    public static void main(String[] args) {
        String a = "hello";
        String b = "o";
        int num = strStr(a,b);
        System.out.println("strSet函数：" + num);
    }

    public static int strStr(String haystack, String needle) {
        int oriLength = haystack.length();
        int destLength = needle.length();
        int index = -1;
        if (StringUtils.isBlank(haystack) || StringUtils.isBlank(needle)) {
            return  0;
        }
        if (oriLength<destLength ) {
            return  -1;
        }
        for (int i=0; i<oriLength-destLength+1; i++) {
            if(haystack.substring(i,i+destLength).equals(needle)) {
                return i;
            }
        }


        return index;
    }

}
