package main

import "math"


func res ( coins []int,num int) int{
	return  getCoins1(coins,0,num)
}
// case-2
// 暴力递归  index 自由选择 coins[index....] 硬币 num目标值
func getCoins1 ( coins []int, index ,num int ) int {
	if num <0{
		return -1
	}
	if num==0 {
		return  0
	}
	if index==len(coins) {
		return  -1
	}
	p1:=float64(getCoins1(coins, index+1, num)) // 不选
	p2:=float64(getCoins1(coins, index+1, num-coins[index])) // 选
	if p1==-1&&p2==-1 {
		return -1
	} else if p1==-1{
		return int(p2)+1
	}else if p2==-1{
		return int(p1)
	} else {
		return int(math.Min(p1,1+p2)) // 选p2+1
	}
}
// dp 数组存结果值，已经算出来就返回 dp[index][res] =[len(coins)][num+1]int
func getCoins2 ( coins []int, index ,num int ,dp [][]int) int {
	if num <0{
		return -1
	}
	if dp[index][num]!=-2 {
		return  dp[index][num]
	}

	if num==0 {
		dp[index][num]=0

	}
	if index==len(coins) {
		dp[index][num]=-1

	}
	p1:=float64(getCoins1(coins, index+1, num)) // 不选
	p2:=float64(getCoins1(coins, index+1, num-coins[index])) // 选
	if p1==-1&&p2==-1 {
		dp[index][num]=-1
	} else if p1==-1{
		dp[index][num]=int(p2)+1
	}else if p2==-1{
		dp[index][num]=int(p1)

	} else {
		dp[index][num]= int(math.Min(p1,1+p2)) // 选p2+1
	}
	return  dp[index][num]
}


// 改为动态规划
func getCoins3 ( coins []int ,num int ) int {
	N:=len(coins)
	dp:=make([][]int,N+2)
	for i:=range  dp {
		dp[i] =make([]int,num+2)
	}
	for row:=0;row<=len(coins)+1 ;row++  {
		dp[row][0]=0
	}
	for col:=1;col<=num ;col++  {
		dp[len(coins)][col]=-1
	}
	for index :=N-1; index>=0;index--  {
		for rest:=1;rest<=num;rest++ {
			p1:=dp[index+1][rest] // 不选
			 p2:=-1
			if rest-coins[index]>0 {
				p2=dp[index+1][num-coins[index]] +1// 选
			}
			if p1==-1&&p2==-1 {
				dp[index][num]= -1
			} else if p1==-1{
				dp[index][num]= int(p2)
			}else if p2==-1{
				dp[index][num]= int(p1)
			} else {
				dp[index][num]=int(math.Min(float64(p1), float64(p2))) // 选p2+1
			}
		}
	}
	return  dp[0][num]
}