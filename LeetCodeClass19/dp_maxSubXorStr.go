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

// 给定123456 串 每个数字后面 添加 + - * 号 能得到aim值有多少种加法
func getTarget(s string,aim int) (ans []string){
	n:=len(s)
	var backtrace func(expr []byte,i,res,m int)
	backtrace= func(expr []byte, i, res, m int) {
		if i==n {
			if res==aim {
				ans=append(ans,string(expr))
			}
			return
		}
		index:=len(expr)
		if i>0 {
			expr=append(expr,0)
		}
		for j,val:=i,0;j<n&&(j==i||s[j]!=0) ;j++  {
			val=val*10+int(s[j]-'0')
			expr=append(expr,s[j])
			if i==0 {
				backtrace(expr,j+1,val,val)
			} else {
				expr[index]='+' ;backtrace(expr,j+1,res+val,val)
				expr[index]='-' ;backtrace(expr,j+1,res-val,-val)
				expr[index]='*' ;backtrace(expr,j+1,res-m+m*val,val*m)
			}
		}
	}
	backtrace(make([]byte,0,2*n-1),0,0,0)
	return
}

type Tree struct {
	val int
	left *Tree
	right *Tree
}

func findKSmallValueBST ( root *Tree,k int) int  {
	stack:=make([]*Tree,0)
	for  {
		for root!=nil  {
			stack=append(stack,root)
			root=root.left
		}
		stack,root=stack[:len(stack)-1],stack[len(stack)-1]
		k--
		if k==0 {
			return root.val
		}
		root=root.right
	}
}

func Qs()	{
	// 队列
	/*stack:=make([]int,0)
	queue:=make([]int,0)
    // 队列 栈 push
    stack=append(stack,1)
	queue=append(queue,1)
     // 栈pop
     val:=stack[len(stack)-1]
	 stack=stack[:len(stack)-1]
	 // queue pop
	 qval:=queue[0]
	 queue=queue[1:len(queue)-1]*/
}
