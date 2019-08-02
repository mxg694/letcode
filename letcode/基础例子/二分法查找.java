package 基础例子;

public class 二分法查找 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        int target = 5;
        search(arr,target);
    }

    public static int search(int[] arr , int  target) {

        if (arr != null && arr.length >0) {
            int max = arr.length-1;
            int min = 0;
            int mid = (max + min) /2 ;
            while (min <= max) {
                if (target > arr[mid]) {
                    min = mid +1;
                }else if(target < arr[mid]) {
                    max = mid -1;
                }else  {
                  return mid;
                }
                mid = (min + max) /2;
            }
        }
        return  -1;
    }


}
