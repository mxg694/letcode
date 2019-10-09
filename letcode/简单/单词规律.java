package 简单;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

 示例1:
 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true

 示例 2:
 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false

 示例 3:
 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false

 示例 4:
 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false

 说明:
 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。


 */
public class 单词规律 {

    public static void main(String[] args) {
        String p = "abc";
        String str = "a b c";
        boolean b = wordPattern(p,str);
        if (b) {
            System.out.println("单词是规律的");
        }else {
            System.out.println("单词无规律");
        }
    }

    public static boolean wordPattern(String pattern, String str) {
            boolean flag =false;
            Map<Character,String> map = new HashMap<>();
            if (StringUtils.isNotBlank(pattern)&& StringUtils.isNotBlank(str) ) {
                String[] arr = str.split(" ");
                if(pattern.length() == arr.length) {
                   for (int i=0; i< arr.length; i++) {
                       if (map.get(pattern.charAt(i))==null) {
                           map.put(pattern.charAt(i), arr[i] );
                       }else {
                           if(!map.get(pattern.charAt(i)).equals(arr[i])) {
                               return false;
                           }
                       }
                   }
                }else  {
                    return false;
                }
            }
            Set<String> set = new HashSet<>();
            int k = 0;

            if(map != null) {
                for (Map.Entry<Character,String> en :map.entrySet()) {
                    k ++;
                    set.add(en.getValue());
                }
            }

            if( k == set.size()) {
                flag = true;
            }
            return flag;
    }
}
