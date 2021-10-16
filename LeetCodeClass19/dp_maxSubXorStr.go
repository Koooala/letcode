package main

import (
	"fmt"
	"math"
)

func getMaxSubXorStr(arrs []int) int {
	xor:=0
	dp:=make([]int,len(arrs))
	mp:=make(map[int]int,0)
	mp[0]=-1
	for i:=0;i<len(arrs) ;i++  {
		xor^=arrs[i]
		if _,ok:=mp[xor];ok{
			pre:=mp[xor]
			if pre!=-1 {
				dp[i]=dp[pre]+1
			} else {
				dp[i]=1
			}
		}
		if i>0 {
			dp[i]= int(math.Max(float64(dp[i-1]), float64(dp[i])))
		}
		mp[xor]=i
	}
	fmt.Print(dp)
	return dp[len(dp)-1]
}
