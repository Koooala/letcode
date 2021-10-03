package main

import "fmt"

func main() {

	//
	// res1:=roobootWalk(5,4,4,2)
	//dp:=make([][]int,0)
   //dp:=-1 todo
   // res2:=roobootWalk2(5,4,4,2,dp)
   // res3:=roobootWalk3(5,4,4,2)
  fmt.Println(res3)
  fmt.Println(res1)
}


// case-1
// N 长度 E结束位置 rest 剩余长度 cur当前位置 暴力递归版
func roobootWalk ( N ,E,rest,cur int) int {
	if rest == 0 {
		if cur == E {
			return 1
		} else {
			return 0
		}
	}
	if cur == 1 {
		return roobootWalk(N, E, rest-1, 2)
	}
	if cur == N {
		return roobootWalk(N, E, rest-1, N-1)
	}
	return roobootWalk(N, E, rest-1, cur-1) + roobootWalk(N, E, rest-1, cur+1)

}
//  带dp数组记录结果值  dp [rest+1][cur+1], dp init all value =-1
func roobootWalk2 ( N ,E,rest,cur int,dp [][]int) int {
	if dp[rest][cur]!=-1 {
		return  dp[rest][cur]
	}
	if rest==0 {
		if cur==E {
			dp[rest][cur]=1
		} else {
			dp[rest][cur]=0
		}
	}
	if cur ==1 {
		dp[rest][cur]=roobootWalk(N,E,rest-1,2)
	}
	if cur==N {
		dp[rest][cur]=roobootWalk(N,E,rest-1,N-1)
	}
	dp[rest][cur]=roobootWalk(N,E,rest-1,cur-1)+roobootWalk(N,E,rest-1,cur+1)
	return dp[rest][cur]
}

// 调整为动态规划解法
func roobootWalk3 (N,P,M,K int) int {
	dp:=make([][]int,N+2)
	for i:=range  dp {
		dp[i] =make([]int,N+2)
	}
    dp[0][P]=1

	for rest:=1;rest<=K ; rest++ {
		for cur:=1;cur<=N ; cur++  {
			if cur==1 {
			  dp[rest][cur]=dp[rest-1][2] // 分别对应上面三次情况
			} else if cur ==N{
				dp[rest][cur]=dp[rest-1][N-1]
			} else  {dp[rest][cur]=dp[rest-1][cur-1]+dp[rest-1][cur+1]
		}}
	}
	return dp[M][K]
}