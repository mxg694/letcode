package 简单;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）
 * 输入非空字符且只包含 1 和 0
 *
 *示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class 二进制求和 {
    public static void main(String[] args) {
       String a = "11";
       String b = "11";

       String c = addBinary(a,b);
        System.out.println("二进制求和："+c);

    }
    
    public static String addBinary(String a, String b) {
        int alen = a.length() -1 ;
        int blen = b.length() -1 ;
        int sum = 0;
        String result = "";

        while (alen >=0 || blen >=0) {
            if (alen >=0) {
                sum += Integer.parseInt(a.substring(alen, alen+1));
                alen--;
            }
            if (blen >=0) {
                sum += Integer.parseInt(b.substring(blen, blen+1));
                blen--;
            }
            if (sum ==2 ) {
                result = "0" + result;
                sum = 1;
            }else if (sum ==0 || sum == 1) {
                result = sum +"" +result;
                sum = 0;
            }else if(sum ==  3){
                result = "1" + result;
                sum = 1;
            }
        }
        if (sum ==1) {
            result = "1" + result;
        }
        return result;
    }
}
