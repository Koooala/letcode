package helloword.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class nQueens {
    // reference golang
  /*  var solutions [][]string

    func solveNQueens(n int) [][]string {
        solutions = [][]string{}
        queens := make([]int, n)
        for i := 0; i < n; i++ {
            queens[i] = -1
        }
        columns,diagonals1, diagonals2 := map[int]bool{},map[int]bool{}, map[int]bool{}
        backtrack(queens, n, 0, columns, diagonals1, diagonals2)
        return solutions
    }

    func backtrack(queens []int, n, row int, columns, diagonals1, diagonals2 map[int]bool) {
        if row == n {
            board := generateBoard(queens, n)
            solutions = append(solutions, board)
            return
        }
        for i := 0; i < n; i++ {
            if columns[i] {
                continue
            }
            diagonal1 := row - i
            if diagonals1[diagonal1] {
                continue
            }
            diagonal2 := row + i
            if diagonals2[diagonal2] {
                continue
            }
            queens[row] = i
            columns[i],diagonals1[diagonal1], diagonals2[diagonal2] = true,true, true
            backtrack(queens, n, row + 1, columns, diagonals1, diagonals2)
            queens[row] = -1
            delete(columns, i)
            delete(diagonals1, diagonal1)
            delete(diagonals2, diagonal2)
        }
    }

    func generateBoard(queens []int, n int) []string {
        var board []string
        for i := 0; i < n; i++ {
            row := make([]byte, n)
            for j := 0; j < n; j++ {
                row[j] = '.'
            }
            row[queens[i]] = 'Q'
            board = append(board, string(row))
        }
        return board
    }

        public int totalNQueens(int n) {
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            return backtrack(n, 0, columns, diagonals1, diagonals2);
        }

        public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
                return count;
            }

    }*/


    public  List<List<String>> sovleQueens(int n){
        List<List<String>>  res =new ArrayList<List<String>>();
        int[] queens =new int[n];
        Arrays.fill(queens,-1);
        // 这三个是不是可以用 bool 数组
        HashSet<Integer> columns =new HashSet<Integer>();
        HashSet<Integer> diagonals1 =new HashSet<Integer>();
        HashSet<Integer> diagonals2 =new HashSet<Integer>();
        backtrack(res,queens,n,0,columns,diagonals1,diagonals2);
        return  res;
    }
    public  void backtrack(List<List<String>>  res,int[] queens ,int n ,int rows,HashSet<Integer> columns,HashSet<Integer> diagonals1,HashSet<Integer> diagonals2){
       if (rows==n){
           List<String> board =genBoard(queens,n);
           res.add(board);

       } else {
           for (int i = 0; i < n; i++) {
               if (columns.contains(i)){
                   continue;
               }
               int diagonal1 =rows-i;
               if (diagonals1.contains(diagonal1)){
                   continue;
               }
               int diagonal2 =rows+i;
               if (diagonals2.contains(diagonal2)){
                   continue;
               }
               queens[rows]=i;
               columns.add(i);
               diagonals1.add(diagonal1);
               diagonals2.add(diagonal2);
               backtrack(res,queens,n,rows+1,columns,diagonals1,diagonals2);
               queens[rows]=-1;
               columns.remove(i);
               diagonals1.remove(diagonal1);
               diagonals2.remove(diagonal2);
           }
       }


    }
    public  List<String> genBoard(int[] queens ,int n){
        List<String> board =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row =new char[n];
            for (int j = 0; j <n ; j++) {
                row[j]='.' ;
            }
            row[queens[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        nQueens queens =new nQueens();
        List<List<String>> res =queens.sovleQueens(4);
        System.out.println(res);
    }
}
