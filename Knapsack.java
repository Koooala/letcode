package helloword.leetcode;

import java.util.Arrays;

public  class Knapsack {
    // v = value
    public static int zeroKnapsack(int V ,int[] cost, int[] w){
        // F [0..V ] ←0
        //   for i ← 1 to N N -N件物品
        //      for v ← V to Ci  V--容量
        //         F [v] ← max{F [v], F [v − Ci] + Wi}
        int[] newResults = new int[11];
        for (int m = 0; m < w.length; m++){
            for (int n = V; n >= cost[m]; n--){
                newResults[n] = Math.max(newResults[n] , newResults[n - cost[m]] + w[m]);
            }
            System.out.println(Arrays.toString(newResults));
        }
        return newResults[newResults.length - 1];
    }

    public static int completeKnapsack(int V , int[] cost,int[] w){
        int[] newResults = new int[11];
        //  F [0..V ] ←0
        //     for i ← 1 to N
        //        for v ← Ci to V
        //           F [v] ← max(F [v],F [v − Ci] + Wi)
        for (int m = 0; m < w.length; m++){
            for (int n = cost[m]; n <= V; n++){
                newResults[n] = Math.max(newResults[n] , newResults[n - cost[m]] + w[m]);
            }
            // 可以在这里输出中间结果
            System.out.println(Arrays.toString(newResults));
        }
        return newResults[newResults.length - 1];
    }
    public static int multiplyKnapsack(int V ,int[] w, int[] cost,int[] ms){
        int[] newResults = new int[V+1];
        //   F[0,1 . . . V ] ← −1
        //   F[0,0] ← 0
        //     for i ← 1 to N
        //       for j ← 0 to V
        //         if F[i − 1][j] ≥ 0
        //            F[i][j] = Mi
        //         else
        //            F[i][j] = −1
        //       for j ← 0 to V − Ci
        //          if F[i][j] > 0
        //            F[i][j + Ci] ← max{F[i][j + Ci], F[i][j] − 1}
        for (int m = 0; m < w.length; m++){
            // 考虑第m个物品
            // 分两种情况
            // 1： ms[m] * vs[m] > c 则可以当做完全背包问题来处理
            if (ms[m] * cost[m] >= V) {
                for (int n = cost[m]; n <= V ; n++) {
                    newResults[n] = Math.max(newResults[n], newResults[n - cost[m]] + w[m]);
                }
            } else {
                // 2： ms[m] * vs[m] < T 则需要在 newResults[n-vs[m]*k] + ws[m] * k 中找到最大值，0 <= k <= ms[m]
                for (int n = V; n >= cost[m] ; n--) {
                    int k = 1;
                    while (k <= ms[m] && n >= cost[m] * k ){
                        newResults[n] = Math.max(newResults[n], newResults[n - cost[m] * k] + w[m] * k);
                        k++;
                    }
                }
            }
            // 可以在这里输出中间结果
            System.out.println(Arrays.toString(newResults));
        }
        return newResults[newResults.length - 1];

    }

    public static void main(String[] args) {
        int[] v = {0,5,7};
        int[] cost = {0,5,5};
        int[] ms={4,2,2};
        int res= zeroKnapsack(10,cost,v);
        System.out.println(res);
       int res2= completeKnapsack(10,cost,v);
        System.out.println(res2);
         /*  int res3= multiplyKnapsack(9,ws,vs,ms);
        System.out.println(res3);*/

    }
}
