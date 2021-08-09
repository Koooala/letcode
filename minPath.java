package helloword.leetcode;

public class minPath {
    public static int  minPth(int[][] path){
        int n =path.length;
        int m =path[0].length;
        if (m == 0) return 0;
        // 初始化dp
        for (int i = 1; i <n ; i++) {path[i][0] += path[i - 1][0];}

        for (int i = 1; i <m ; i++) {path[0][i] += path[0][i-1];}
        // 思路很简单 选取左右最下一个累加 greedy
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                path[i][j]+= Math.min(path[i-1][j] ,path[i][j-1]);
            }
        }
        return path[n-1][m-1];

    }

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1,3,1}, {1,5,1}, {4, 2,1}};
        int res=minPth(arr1);
        System.out.println(res);
    }

}
