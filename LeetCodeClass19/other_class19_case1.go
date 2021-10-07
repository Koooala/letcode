package main

import "fmt"

//case-1 找出()()()((() 给出这个括号 请给出添加多少个括号才能组成合法括号
func getNums (arrs string) int{
	// count 遍历每一个 字符 ，如果（就+1 ）就-1，如果当前 count==0 且是（结果就+1, 最后结果就是 cur+ans
   ans:=0
   count:=0
	for i:=0;i<len(arrs) ;i++  {
		if arrs[i]== '(' {
		   count++	
		} else if count==0 {
			ans++
		} else {
				count--
		}
	}
	return count+ans
}

// case-2
//给点节点数为n,能组成多少颗二叉树
func getTreeNums (num int) int {
	// 分析
	if num==0 {
		return 1
	}
	if num==1 {
		 return 1
	}
	if num==2 {
		return  2
	}
	ans :=0
	for i:=0;i<=num-1; i++ {
		// 左边i个节点 右边 n-i-1个节点
     temp:=getTreeNums(i)*getTreeNums(num-1-i)
     ans+=temp
	}
   return ans
}

func DpGetTreeNums (num int) int {
	// 分析
	if num<2 {
		return 1
	}
	dp:=make([]int,num+1)
	dp[0]=1
	dp[1]=1
	dp[2]=2
	for i:=3;i<=num; i++ {
		for j:=0;j<i ;j++  { // j 给左孩子分配多少点 i-j 给右孩子分配多少个点
		    temp:=dp[j]*dp[i-j-1]
			dp[i]=dp[i]+temp
		}
		// 左边i个节点 右边 n-i-1个节点
	}
	return dp[num]
}




func  main()  {
	s:=getTreeNums(4)
	t:=DpGetTreeNums(4)
	fmt.Println(s)
	fmt.Print(t)
}