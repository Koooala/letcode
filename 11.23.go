package main

import (
	"fmt"
	"math"
)

func coinChange(coins []int, amount int) int {
	dp:=make([]int,amount+1)
	for i:=0;i<amount+1 ;i++  {
		dp[i]= amount+1
	}
	dp[0]=0
	for i:=1;i<amount+1 ;i++  {
		for j:=0;j<len( coins) ;j++  {
			if coins[j]<=i {
				dp[i]= int(math.Min(float64(dp[i]), float64(dp[i-coins[j]]+1)))
			}
		}
	}
	fmt.Println(dp)
	if dp[amount]>amount {
		return -1
	} else {
		return dp[amount]
	}
}

func minPathSum(grid [][]int) int {
     row:=len(grid)
     col:=len(grid[0])
    dp:=make([][]int,row)
	for i:=0;i<len(dp) ;i++  {
		dp[i]= make([]int,col)
	}
	dp[0][0]=grid[0][0]
	for i:=1;i<col ; i++ {
     dp[0][i]=dp[0][i-1]+grid[0][i]
	}
	for i:=1;i<row ; i++ {
		dp[i][0]=dp[i-1][0]+grid[i][0]
	}
	for i:=1;i<row ;i++  {
		for j:=1;j<col ;j++  {
			dp[i][j]=grid[i][j]+ int(math.Min(float64(dp[i-1][j]), float64(dp[i][j-1])))
		}
	}
	fmt.Println(dp)
    return dp[row-1][col-1]
}

func swapTarget(nums []int ,tar int)(index int){

	for i:=0;i<len(nums) ;i++{
		if nums[i]==tar {
			nums[i],nums[index]=nums[index],nums[i]
			index++
		}
	}
	return index
}
func sortColors(nums []int) {
	index0:=swapTarget(nums,0)
	swapTarget(nums[index0:],1)
}


func isPalindromeNode(head *ListNode) bool {
	if head==nil {
		return  true
	}
	val:=make([]int,0)
	for head!=nil  {
		val=append(val,head.Val)
		head=head.Next
	}

	i:=0
	r:=len(val)-1
	for i<r {
		if val[i] != val[r]{
			return false
		}
		i++
		r--
	}
	return true

}
