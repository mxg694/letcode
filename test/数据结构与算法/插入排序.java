package 数据结构与算法;

import java.util.Arrays;

/**
 *
 */
public class 插入排序 {

    private static int[] arr = {2,1,3};

    public static void main(String[] args) {
        insertSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort( ){
        int select = 0;
        for (int i=1; i<arr.length; i++) {
            select = arr[i];
            int  j = 0;
            //for ()不是每次都能执行到 或者执行完毕    可以类比冒泡排序
            for (j=i; j>0 &&arr[j-1] > select; j--) {  //前一个值是否大于当前的值
                arr[j] = arr[j-1];
            }
            arr[j] = select;
        }
    }
}
