package helloword.leetcode;

public class validSudoku {
    public  static  boolean valid(char[][] board ){
        boolean[][] row =new boolean[9][9];
        boolean[][] col =new boolean[9][9];
        boolean[][] block =new boolean[9][9];

        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if (board[i][j]!='.'){
                    int num= board[i][j] -'1';
                    // 坐标转换
                    // 0 1 2
                    // 3 4 5
                    // 6 7 8
                    int blockIndex = i/3*3+j/3;

                    if (row[i][num]|| col[i][num]||block[blockIndex][num]){
                        return false;
                    } else {
                        row[i][num]=true;
                        col[i][num]=true;
                        block[blockIndex][num]=true;
                    }
                }
            }
        }
        return true;
    }
}
