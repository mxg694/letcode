package lambda;

import java.util.ArrayList;
import java.util.List;

/**
 *  lambda  使用map  可以改变你的对象
 */
public class 利用Lambda实现Map和Reduce {

    public static void main(String[] args) {
        List<Integer> numlist = new ArrayList<>();
        numlist.add(100);
        numlist.add(200);
        numlist.add(300);

        for (int num :numlist) {
            double price =  num + 0.12 * num;
            System.out.println(price);
        }

        numlist.stream().map((cost)->cost+0.12*cost ).forEach(System.out :: println);
        //-----reduce  的使用
        double total = 0;
        for(int n : numlist) {
            double price = n +0.12*n;
            total = total + price;
        }
        System.out.println("java8之前 total:"+total);
        //使用 lambda 表达式
        double bill = numlist.stream().map((cost)->cost+0.12*cost)
                .reduce((sum,cost)->sum+cost).get();
        System.out.println("in java8 bill:"+bill);
    }

}
