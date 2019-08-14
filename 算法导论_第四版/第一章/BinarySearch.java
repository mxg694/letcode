package 第一章;

import java.util.Arrays;

public class BinarySearch {


    private BinarySearch() {
    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }


    public static void main(String[] args) {

        int[] whitelist = {1, 2, 3, 4, 5};
        int key = 2;

        Arrays.sort(whitelist);

        if (BinarySearch.indexOf(whitelist, key) == -1){
            System.out.println("二分法key:"+key);
        }else{
            System.out.println("找到数据了");
        }
    }
}