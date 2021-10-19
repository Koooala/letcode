package main

import (
	"fmt"
	"math"
	"sort"
	"strconv"
)

func longestPalindrome (s string ) string{
	if s=="" {
		return  ""
	}
     st,e:=0,0
	for i:=0;i<len(s) ;i++  {
		l1,r1:=expand(s,i,i)
		l2,r2:=expand(s,i,i+1)
		if r1-l1>e-st {
			st,e=l1,r1
		}
		if r2-l2>e-st {
			st,e=l2,r2
		}
	}
	return s[st:e+1]
}

func  expand (s string ,left,right int) (l,r int){
	for ;left<right &&left>=0&&right<len(s)&&s[left]!=s[right]; left,right=left+1,right-1 {
	}
	return left+1,right-1
	
}

func isPalindrome(x int) bool {
	s:=strconv.Itoa(x)
	r:=len(s)
	for i:=0;i<len(s) ;i++  {
		if s[i] != s[r-1]{
			return false
		}
		r--
	}
	return true
}

func maxArea(height []int) int {
    ans:=0
    r:=len(height)-1
    i:=0
	for i<r {
		m:=height[r]
		n:=height[i]
		area:=int(math.Min(float64(n), float64(m)))* (r-i)
		ans= int(math.Max(float64(ans), float64(area)))
		if height[i]<height[r] {
			i++
		} else {
			r--
		}
	}
	return  ans
}


  type ListNode struct {
      Val int
      Next *ListNode
  }

func getIntersectionNode(headA, headB *ListNode) *ListNode {
   mp:=make(map[*ListNode]bool,0)
	for t:=headA;t!=nil ;t=t.Next  {
		mp[t]=true
	}
	for t:=headB;t!=nil ;t=t.Next  {
		if mp[t] {
			return t
		}
	}
	return nil
}


func nearThreeSum(nums []int,target int) (res int) {
	sort.Ints(nums)
	ans:=nums[0]+nums[1]+nums[2]
	for i := 0; i < len(nums); i++ {
		j, k := i + 1, len(nums) - 1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if math.Abs(float64(target - sum))<math.Abs(float64(target-res)) {
				ans=sum
			}
			if sum>target {
				k--
			} else if sum < target {
				j++
			} else {return ans
			}

		}
	}

	return ans
}


func  main()  {
	nus:=[]int{1,1,1,1}

	fmt.Println(nearThreeSum(nus,0))
}