package 数据结构与算法.递归;

/**
 * 递归方法的调用
 * 汉诺塔谜题
 *
 *算法:
 *  将圆柱最上面的n-1 个圆盘 移到辅助柱
 *  将第n个圆盘 从圆柱移到目标柱
 *  将辅助柱的n-1个圆盘移到目标柱
 *
 * 3个圆盘  a <b < c
 *  将 圆柱 a 移到辅助柱
 *  第 圆柱 b移到目标柱
 *  将辅助柱的 a 移到目标柱
 * 将 圆柱  c  移到辅助柱，
 * 将目标柱的 a 移到 辅助柱
 * 将目标柱的 b 移到圆柱
 * 将辅助柱的  a  移到圆柱
 * 将辅助柱的 c  移到目标柱
 * 将圆 a 移到辅助柱
 * 将源柱的 b 移到目标柱
 * 将辅助柱的 a 移到目标柱
 *
 * 3个圆盘  a  b  c
 *
 * Move disk a from peg ArrayStack to peg B
 * Move disk b from peg ArrayStack to peg C
 * Move disk a from peg B to peg C
 * Move disk c from peg ArrayStack to peg B
 * Move disk a from peg C to peg ArrayStack
 * Move disk b from peg C to peg B
 * Move disk a from peg ArrayStack to peg B
 */
public class 汉诺塔 {

    public static void main(String[] args) {
        towersOfHanoi(3,'A','B','C');
    }

    /**
     * 汉诺塔 算法 实现
     * @param n
     * @param frompeg     原柱
     * @param topeg       目标柱
     * @param auxpeg      中间柱
     */
    public static void towersOfHanoi( int n ,char frompeg, char topeg, char auxpeg  ) {
        /*如果仅有一个圆盘，直接移动，然后返回*/
        if(n == 1) {
            System.out.println("Move disk 1 from peg" +frompeg + "to peg"+ topeg);
            return;
        }
        /*利用c柱作为辅助，将A柱最上面一层n-1个圆柱移到B柱*/
        towersOfHanoi(n-1, frompeg,auxpeg,topeg);
        /*将余下的圆盘从A柱移到c柱*/
        System.out.println("Move disk "+n+ " from peg" +frompeg + "to ` peg "+topeg);

        //利用A柱作为辅助，将B柱上的n-1个圆盘移到C柱
        towersOfHanoi(n-1,auxpeg,topeg,frompeg);

    }


    /* 给定一个数组 ， 请用递归方法判断数组元素是否是有序的*/
    int isArrayInSortedOrder(int[] A,int index) {
        if (A.length == 1) {
            return 1;
        }
        return (A[index-1] <=A[index-2]?0:isArrayInSortedOrder(A,index-1));
    }
}
