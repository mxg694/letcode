package 简单;

import org.apache.commons.lang3.StringUtils;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 *有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 步骤：
 *     判断字符串
 *
 *     contains  如果包含  则直接删除
 *
 */
public class 有效的括号 {
    private static  final String  a = "{}";
    private static  final String  b = "[]";
    private static  final String  c = "()";
    private static  boolean flag = false;
    public static void main(String[] args) {
        String s = "{}())";
        isValid(s);

     /*String s = "ababababababbbb";
     s = s.replace("ab","");
     System.out.println(s);*/

    }

    public static void isValid(String s) {
        String rest = "";
        if(StringUtils.isNotBlank(s)) {
            if(s.contains(a) ) {
                s = s.replace(a,"");
            } if( s.contains(b)  ){
               s= s.replace(b,"");
            }else if( s.contains(c)  ){
               s= s.replace(c,"");
            }
        }
        if (StringUtils.isBlank(s) ) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}

