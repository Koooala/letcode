package helloword.leetcode;

import java.util.Arrays;

public class rotateImage {

    public  static void rotate(int[][] matrix){
        int row= matrix.length;
        // 沿着 水平中线翻转
        for (int i = 0; i <row/2 ; i++) {
            for (int j = 0; j <row ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-i-1][j];
                matrix[row-i-1][j] = temp;
            }
        }
       // 沿着主对角线翻转
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <i ; j++) {
                int temp =matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }

    public static void main(String[] args) {
       int[][] arr={{1,2,3},{4,5,6},{7,8,9}};

       rotate(arr);
        for (int[] ints : arr) {
            System.out.print(Arrays.toString(ints));
        }


    }

}
