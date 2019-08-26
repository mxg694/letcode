package 数组.中等;

import java.util.Arrays;

/**
 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]

 示例 2:

 给定 matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]


 */
public class 旋转图像_1 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4,5,6},
            {7,8,9,10,11,12},
            {13,14,15,16,17,18},
            {19,20,21,22,23,24},
            {25,26,27,28,29,30},
            {31,32,33,34,35,36}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int k = 0; k < n / 2; k++) {
            for (int i = 0; i < ((n - 2 * k) - 1); i++) {
                int tmp = matrix[k][k + i];
                matrix[k][k + i] = matrix[n - 1 - (k + i)][k];
                matrix[n - 1 - (k + i)][k] = matrix[n - 1 - k][n - 1 - (k + i)];
                matrix[n - 1 - k][n - 1 - (k + i)] = matrix[k + i][n - 1 - k];
                matrix[k + i][n - 1 - k] = tmp;
            }
        }

        for (int i =0 ;i<   n ; i++) {
            System.out.println("旋转图像_1：" + Arrays.toString(matrix[i]));
        }
    }

}
