package 啊哈算法;

public class 深度优先搜索 {
   static int[] a = new int[10];
    static  int[] book = new int[10];
    static   int  n = 0;
    public static void main(String[] args) {
        n = 2;
        dfs(1);
    }

    public static void  dfs(int step) {
        int i ;
        if(step == n+1) {// 如果站在第 n+1个盒子面前，则表示n个盒子已经放好扑克牌
            //输出一种排列
            for (i = 1; i<= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return; //返回之前的一步
        }
        //此时站在第step个盒子面前，
        //按照1,2,3，，，，n的顺序一一尝试
        for ( i =1 ;i <= n; i++) {
            if (book[i] == 0) { //book[i] 等于0 表示i号扑克牌在手上
                //开始尝试使用扑克牌
                a[step] = i; //将i号扑克牌放到第step 个盒子中
                book[i] = 1;
                //第 step个盒子已经放好扑克牌，需要走到下一个盒子面前
                dfs(step + 1); //递归调用
                book[i] = 0; // 将刚才尝试的扑克牌收回 ？为什么？
            }
        }
        return;

    }


   public void 深度优先搜索模型(int step) {
        //判断边界
       //尝试每一种可能
       for (int i=0; i< n; i++) {
           //继续下一步
           深度优先搜索模型(step+1);
       }
       //返回
       return;
   }
}
