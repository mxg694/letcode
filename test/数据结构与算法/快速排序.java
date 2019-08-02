package 数据结构与算法;

import java.util.Arrays;

public class 快速排序 {

    private static int[] arr = {2,1,3};

    public static void main(String[] args) {
        quicksort(0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int left, int right ){
        int  i =0;
        int j =0;
        int t = 0;
        int temp = 0;

        if (left >right) {
            return;
        }
        temp = arr[left];
        i = left;
        j=right;
        while (i != j) {
            //顺序很重要 先从右往左
            while (arr[j] >=temp && i < j) {
                j--;
            }
            //从左往右
            while (arr[i] <=temp && i < j) {
                i++;
            }

            //交换两个数在数组中的位置
            if (i < j) {
                t= arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
            //将基准数归位
            arr[left]  =arr[i];
            arr[i] = temp ;
            quicksort(left,i-1);//继续处理左边的，这里是一个递归的过程
            quicksort(i+1,right);//继续处理右边的，这里是一个递归的过程
        }

    }
}
