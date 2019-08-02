package 啊哈算法;

import org.junit.Test;

/**
 * 栈： 先进后出
 */
public class 用栈实现回文 {

    @Test
    public void 回文() {
        char[] s = new char[101];
        char[] a = {'a','c','c','a'};
        int i,len,mid,next,top;

        len = a.length; //求字符串的长度
        mid = len /2 -1; //求字符串的中点

        top = 0;
        //将mid之前的字符依次入栈
        for (i= 0; i<=mid; i++) {
            s[++top] = a[i];
        }
        //判断字符串的长度是奇数还是偶数，并找出需要进行字符匹配的起始下标
        if(len%2==0)
            next=mid+1;
        else
            next=mid+2;

        //开始匹配
        for(i=next;i<=len-1;i++){
            if(a[i]!=s[top])
                break;
            top--;
        }
        //如果top的值为0，则说明栈内所有的字符都被一一匹配了
        if(top==0)
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
