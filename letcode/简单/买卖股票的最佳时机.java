package 简单;

/**
 * 给定一个数组，它的第i个元素是一支给定股票的第i天的价格
 * 如果每天最多只允许完成一笔交易（即买入卖出一支股票）
 * 设计一个算法来计算你所能获取的最大利润
 *不能在买入股票前卖出股票
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int max = maxProfit(nums);
        System.out.println("买卖股票的最佳时机："+max);
    }

    /**
     *   一个是价钱  一个是日期
     *   判断当前 日期 的价格 是否是最低，最低价格 之后的日期有 的最大价格
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices !=null && prices.length>0) {
            if (prices.length ==1) {
                return 0;
            }
            //获取最小的价格 和日期
            //最小价格日期之后的最大价格
            int[] dp = new int[prices.length];
            int minPrice = prices[0];
            for(int i = 1; i < prices.length; i++){
                minPrice = Math.min(minPrice, prices[i]); //两个值比较最小
                dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);//只需记住当前的最小值即可
            }
            return dp[prices.length - 1];

        }

        return 0;
    }

}
