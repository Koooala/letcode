package main

import (
	"fmt"
	"math"
)

func removeElement(nums []int, val int) int {

	index:=0
	for _,num:=range  nums {
		if num!=val {
			nums[index]=num
			index++
		}
	}
	fmt.Println(nums)
   return  index
}


func maxDepth(root *TreeNode) int {
	if root==nil{
    	return  0
	}
    return int(math.Max(float64(maxDepth(root.Left)), float64(maxDepth(root.Right))))+1
}

func searchInsert(nums []int, target int) int {
	n:=len(nums)
	for i:=0;i<n ;i++  {
		if nums[i]>=target {
			return i
		}
	}
	return n
}

func isValid(s string) bool {
	n := len(s)
	if n % 2 == 1 {
		return false
	}
	pairs := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := make([]byte,0)
	for i:=0 ;i<n ;i++  {
		if pairs[s[i]]>0 {
			if len(stack)==0|| pairs[s[i]]!=stack[len(stack)-1] {
              return false
			}
          stack=stack[:len(stack)-1]
		} else {
			stack=append(stack,s[i])
		}
	}
return  len(stack)==0
}

func combinationSum(candidates []int, target int)  (ans [][]int) {
	//  候选集，路径，目标，层数
	var dfs1 func(can []int,path []int,target, idx int)
	    dfs1= func(can []int,path []int,target, idx int) {
			if idx==len(can) {
				return
			}
			if target==0 {
				ans=append(ans,append([]int{},path...))
				return
			}
             dfs1(can,path,target,idx+1)
			if target-can[idx]>=0 {
				path=append(path,can[idx])
				dfs1(can,path,target-can[idx],idx)
				path=path[:len(path)-1]
			}

	}
	    path:=make([]int,0)
    dfs1(candidates,path,target,0)
	return
}




// 1 5 8 5 4 7 6 5 3 1
func nextPermutation(nums []int)  {
    n:=len(nums)
    f:=n-2
    // 从右向左遍历  先找到第一个不递增的数 “4”
	for n>0&&nums[f]>=nums[f+1] {
		f--
	}
    // 从右向左遍历  找到第一个大于“4” 的数 “5” 将他两交换
	if f>=0 {
		s:=n-1
		for n>0&&nums[f]>nums[s] {
			s--
		}
		nums[f],nums[s]=nums[s],nums[f]
	}
    // 反转 “4” 到end 位置的所有数
    reverseInt(nums[f+1:])
}

func reverseInt (nums []int){
	for l:=0;l<len(nums)/2 ;l++ {
		nums[l],nums[len(nums)-l-1]= nums[len(nums)-l-1],nums[l]
	}
	fmt.Println(nums)
}

func ser2(n int)[][]int {
	matrix := make([][]int, n)
	for i := range matrix {
		matrix[i] = make([]int, n)
	}
	left,top,right,bottom:=0,0,n-1,n-1
	index:=1
	for left<=right&&bottom>=top {
		// (top,left) -> (top,right)
		for i:=left;i<=right ;i++  {
			matrix[top][i]=index
			index++
		}
		//	(top+1,right) -> (bottom,right)
		for i:=top+1;i<=bottom ;i++  {
			matrix[i][right]=index
			index++
		}

		if left<right&&top<bottom {
			//	(bottom,right-1) -> (bottom,left+1)
			for i:=right-1;i>left ;i--  {
				matrix[bottom][i]=index
				index++
			}
			// 	//	(bottom,left) -> (top+1,left)
			for i:=bottom;i>top ;i--  {
				matrix[i][left]=index
				index++
			}
		}
		top++
		left++
		right--
		bottom--
	}
	return matrix
}



type Node struct {
	Val int
	Children []*Node
}


func maxDepthNTree(root *Node) int {
	if root==nil {
		return 0
	}
	ans:=0
	for _,children:=range root.Children {
		ans= int(math.Max(float64(ans), float64(maxDepthNTree(children))))
	}
	return  ans+1
}

func trap(height []int) int {
	n:=len(height)
	if n<=2 {
		return 0
	}
	l,r:=0,n-1
	lm,rm,ans:=0,0,0
	for l<r {
		if height[l]<height[r] {
			if height[l]>=lm {
				lm=height[l]
			} else {
				ans=ans+ (lm-height[l])
			}
			l++
		} else {
			if height[r]>=rm {
				rm=height[r]
			} else {
				ans=ans+ (rm-height[r])
			}
			r--
		}
	}
	return  ans
}
func main(){

	test:=[]int{2,3,6,7}
	nextPermutation(test)



}