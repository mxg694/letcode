package 啊哈算法;

public class 栈和队列实现小猫钓鱼 {

    public static void main(String[] args) {
        queue q1 = new queue(), q2 = new queue();  //双方手里的牌
        stack s = new stack();  //桌子上的数据
        int[] book = new int[10];
        int i, t;

        //初始化队列
        q1.head = 1;
        q1.tail = 1;
        q2.head = 1;
        q2.tail = 1;

        //初始化栈
        s.top = 0;
        q1.data[1] = 2;
        q1.data[2] = 4;
        q1.data[3] = 1;
        q1.data[4] = 2;
        q1.data[5] = 5;
        q1.data[6] = 6;

        q2.data[1] = 2;
        q2.data[2] = 1;
        q2.data[3] = 3;
        q2.data[4] = 5;
        q2.data[5] = 6;
        q2.data[6] = 4;
        q1.tail = 7;
        q2.tail = 7;

        while (q1.head < q1.tail && q2.head < q2.tail) { //当队列不为空的时候执行循环
            t=q1.data[q1.head];//小哼出一张牌
            //判断小哼当前打出的牌是否能赢牌
            if(book[t]==0) { //表明桌上没有牌面为t的牌\
                //小哼此轮没有赢牌
                q1.head++; //小哼已经打出一张牌，所以要把打出的牌出队
                s.top++;
                s.data[s.top]=t; //再把打出的牌放到桌上，即入栈
                book[t]=1; //标记桌上现在已经有牌面为t的牌
            }else  {
                //小哼此轮可以赢牌
                q1.head++;//小哼已经打出一张牌，所以要把打出的牌出队
                q1.data[q1.tail]=t;//紧接着把打出的牌放到手中牌的末尾
                q1.tail++;
                while(s.data[s.top]!=t) {//把桌上可以赢得的牌依次放到手中牌的末尾
                    book[s.data[s.top]]=0;//取消标记
                    q1.data[q1.tail]=s.data[s.top];//依次放入队尾
                    q1.tail++;
                    s.top--; //栈中少了一张牌，所以栈顶要减1
                }
            }
            t=q2.data[q2.head]; //小哈出一张牌
            //判断小哈当前打出的牌是否能赢牌
            if(book[t]==0){ //表明桌上没有牌面为t的牌
                //小哈此轮没有赢牌
                q2.head++; //小哈已经打出一张牌，所以要把打出的牌出队
                s.top++;
                s.data[s.top] = t; //再把打出的牌放到桌上，即入栈
                book[t] = 1; //
            }else  {
                //小哈此轮可以赢牌
                q2.head++;//小哈已经打出一张牌，所以要把打出的牌出队
                q2.data[q2.tail]=t;//紧接着把打出的牌放到手中牌的末尾
                q2.tail++;
                while(s.data[s.top]!=t) {//把桌上可以赢得的牌依次放到手中牌的末尾
                    book[s.data[s.top]]=0;//取消标记
                    q2.data[q2.tail]=s.data[s.top];//依次放入队尾
                    q2.tail++;
                    s.top--;
                }
            }
        }
        if(q2.head==q2.tail)
        {
            System.out.println("小哼win\n");
            System.out.println("小哼当前手中的牌是");
            for(i=q1.head;i<=q1.tail-1;i++)
                System.out.println(q1.data[i]);
            if(s.top>0){ //如果桌上有牌则依次输出桌上的牌
                System.out.println("\n桌上的牌是");
                for(i=1;i<=s.top;i++)
                    System.out.print(s.data[i] + "  ");
            } else
                System.out.println("\n桌上已经没有牌了");
        }
        else {
            System.out.println("小哈win\n");
            System.out.println("小哈当前手中的牌是");
            for(i=q2.head;i<=q2.tail-1;i++)
                System.out.println(q2.data[i]);
            if(s.top>0){ //如果桌上有牌则依次输出桌上的牌
                System.out.println("\n桌上的牌是");
                for(i=1;i<=s.top;i++)
                    System.out.println(s.data[i]);
            } else
                System.out.println("\n桌上已经没有牌了");
        }
    }

}

//栈
class  stack {
  public int[] data = new int[10];
  public int top = 0;

}

//队列
class queue {
    public int[] data = new int[1000];
    public int head =0;
    public int tail = 0;
}