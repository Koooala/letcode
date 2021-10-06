package main

func findTargetSumWays(nums []int, target int) int {
	return f2(nums,target,0,0)
}

func f2 (nums []int,target ,curSum,cur int) int{
	if len(nums)==cur {
		if curSum==target{return 1}
		return 0
	}
	// 加负号
	left:=f2(nums,target,curSum-nums[cur],curSum+1)
	// 加正号
	right:=f2(nums,target,curSum+nums[cur],curSum+1)
	return left+right
}
// dp 缓存
func f3 (nums []int,target ,curSum,cur int,dp [][]int) int{
	if len(nums)==cur {
		if curSum==target{
			dp[curSum][cur]=1
		}
		dp[curSum][cur]=0
	}
	if dp[curSum][cur]!=1001 {
    	return dp[curSum][cur]
    }
	// 加负号
	left:=f2(nums,target,curSum-nums[cur],curSum+1)
	// 加正号
	right:=f2(nums,target,curSum+nums[cur],curSum+1)
	dp[curSum][cur]=left+right
	return dp[curSum][cur]
}