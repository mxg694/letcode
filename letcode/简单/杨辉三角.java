package 简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class 杨辉三角 {

    public static void main(String[] args) {
        List<List<Integer>> l = generate(5);

        for (List<Integer> i: l ) {
            System.out.println(Arrays.toString(  i.toArray() ));
        }
    }

    /**
     *    1、numRows 为几   最下层的数组数量便是几
     *    每个数组第一个和最后一位 数值固定
     *    第一、二行 是固定死的
     *    从第三行开始    需要计算的下标的值 是 上一个数组的这个下标的和前一个下标的和
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i= 0; i< numRows; i++) {   //i 为下标
            List<Integer>  listi =  new ArrayList<>();
            listi.add(1);

            if (i>= 1) {
                for (int t =1; t<=i; t++) {
                    listi.add(1);
                }
                List<Integer> l = list.get(i-1);
                for (int j=1; j<i; j++) {
                    listi.set(j, (l.get(j)+l.get(j-1)));
                }
            }

            list.add(listi);
        }

        return list;
    }

}
