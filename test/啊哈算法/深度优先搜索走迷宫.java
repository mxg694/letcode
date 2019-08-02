package 啊哈算法;

public class 深度优先搜索走迷宫 {
    static int n =0 ;
    static int m = 0;
    static int p ;
    static int q;
    static int min = 999999999;

    static int[][] a = new int[51][51];
   static int[][] book = new int[51][51];

    public static void main(String[] args) {
        int i,j, startx = 0, starty= 0;  //起点坐标 p,q 终点坐标
        n = 50;
        m = 50;
        //构建迷宫
        for ( i = 1; i<=n; i++) {
            for (j =1; j<=m ; j++) {

            }
        }

        book[startx][starty] = 1; //标记起点已经在路径上，防止以后走重复
        //起点坐标 终点坐标  初始步数
        dfs(startx,starty,0);

        System.out.println("最短步数：" + min);

    }


   static void dfs(int x, int y, int step ) {
        int[][] next = {
            {0,1}, //向右走
            {1,0}, //向下走
            {0,-1}, //向左走
            {-1,0}, //向上走
        };

        int tx, ty, k;
        //判断是否到达小哈的位置
        if(x ==p  && y == q) {
            if (step < min) { //更新最小值
                min = step;
            }
            return;
        }

        //4  种枚举走法
        for (k =0 ; k<=3 ; k++) {
            //计算下一个点的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];
            //判断是否越界
            if(tx< 1 || tx > n || ty <1 || ty > n) {
                continue;
            }
            //判断该点是否为障碍物或者已经在路上
            if(a[tx][ty] == 0 && book[tx][ty] ==0 ) {
                book[tx][ty] = 1; //标记这个点已经走过
                dfs(tx, ty,step+1);
                book[tx][ty] = 0; //尝试结束，取消这个点的标记
            }
        }
        return;
    }
}
