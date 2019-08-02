package 简单;

import org.apache.commons.lang3.StringUtils;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class 最后一个单词的长度 {

    public static void main(String[] args) {
        String s = "Hello World ";
        int lengthoflastWord = lengthOfLastWord(s);
        System.out.println("最后一个单词的长度："+lengthoflastWord);

    }

    public static Integer lengthOfLastWord(String s) {
        if (StringUtils.isNotBlank(s)) {
            String[] arr = s.split(" ");
            String lastword = arr[arr.length-1];
            return  lastword.length();
        }
        return  0;
    }
}
