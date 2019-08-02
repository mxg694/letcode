package 简单;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。

 *所有输入只包含小写字母 a-z 。
 */
public class 最长的公共前缀 {

    public static void main(String[] args) {
        String[]arr = new String[3];
        arr[0]= "aaa";
        arr[1]= "aaaaa";
        arr[2]= "aaaa";
 //       Arrays.sort(arr);
        longestCommonPrefix(arr);
    }

    public static void longestCommonPrefix (String[] arr) {
        int count = arr.length;
        String prefix = "";
        if(count != 0) {
            prefix = arr[0];
        }
        for (int i = 0; i< count; i++) {
           // 关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while ( !arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        System.out.println(prefix);
    }
}
