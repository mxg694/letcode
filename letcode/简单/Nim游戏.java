package 简单;

/**
 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
 拿掉最后一块石头的人就是获胜者。你作为先手。
 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

 示例:

 输入: 4
 输出: false
 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。


 执行结果：通过
 显示详情
 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
 内存消耗 :33.3 MB, 在所有 Java 提交中击败了11.50%的用户

 */
public class Nim游戏 {

    public static void main(String[] args) {
        int num = 4;
        boolean b = canWinNim(num);
        if (b) {
            System.out.println("可以Nim");
        }else {
            System.out.println("不可以nim");
        }
    }

    public static boolean canWinNim(int n) {
        if (n<=3) {
            return true;
        }else {
            if (n % 4 == 0) {
                return false;
            }else {
                return true;
            }
        }
    }

}
