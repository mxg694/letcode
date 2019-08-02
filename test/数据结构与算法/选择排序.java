package 数据结构与算法;

import java.util.Arrays;

/**
 * 	扫描所有元素，将得到最小的元素，并将最小的元素与左边第一个交换
 * 	再次扫描除第一位置的所有元素，得到最小的元素，与左边第二个元素进行交换
 * 	以此类推
 *
 */
public class 选择排序 {

    private static int[] arr = {10,45,78,21,};

    public static void main(String[] args) {
        selectSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort( ){
        int min;
        int temp ;

        for (int i =0 ; i< arr.length-1 ; i++) {  //获取从那个起始位置开始
            min = i;
            for (int j= i+1; j<arr.length; j++) {  //遍历数组中 除起始位置 剩下元素，
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            //交换
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
    }
}
