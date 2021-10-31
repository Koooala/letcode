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
	i:=0
	r:=len(s)-1
	for i<r {
		if s[i] != s[r-1]{
			return false
		}
		i++
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

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1==nil&&l2==nil {
		return nil
	}
	if l1==nil&&l2!=nil {
		return l2
	}
	if l1!=nil&&l2==nil {
		return l1
	}
	if l1!=nil&&l2!=nil  {
		if l1.Val<l2.Val {
			l1.Next=mergeTwoLists(l1.Next,l2)
			return l1
		} else {
			l2.Next=mergeTwoLists(l1,l2.Next)
			return l2
		}
	}
	return nil
}

func mergeKLists(lists []*ListNode) *ListNode {

	var ans *ListNode
	for i:=0;i<len(lists) ;i++  {
		ans= mergeTwoLists(ans,lists[i])
	}
	return ans
}

func hasCycle(head *ListNode) bool {
	mp := map[*ListNode]struct{}{}
	for head != nil {
		if _, ok := mp[head]; ok {
			return true
		}
		mp[head] = struct{}{}
		head = head.Next
	}
	return  false
}

func removeDuplicates(nums []int) int {
	if len(nums)==0 {
		return 0
	}
	s:=1
	for i:=1;i<len(nums) ;i++  {
		if nums[i] != nums[i-1] {
			nums[s]=nums[i]
			s++
		}
	}
	return s
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


func climbStairs(n int) int {
	if n<=2 {
		return n
	}
	n1:=1
	n2:=2
	for i:=3;i<=n ;i++  {
		tem:=n1+n2
		n1=n2
		n2=tem

	}
	return  n2
}


func generateParenthesis(n int) []string {
	res:=make([]string,0)
	var DFS func(s string, lc int, rc int, ans *[]string)
	DFS=func (s string, lc int, rc int, ans *[]string) {
		if lc==0&&rc==0 {
			*ans=append(*ans,s)
			return
		}
		if lc>0 {
			DFS(s+"(", lc-1, rc, ans)
		}
		if rc>lc {
			DFS(s+")", lc, rc-1, ans)
		}

	}
	DFS("",n,n,&res)
	return  res
}
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) (res []int) {
	var inorder func(root *TreeNode)
	inorder = func(root *TreeNode) {
		if root == nil {
			return
		}
		inorder(root.Left)
		res = append(res, root.Val)
		inorder(root.Right)
	}
	inorder(root)
	return
}




func search(nums []int, target int) int {
	n:=len(nums)
	l,r:=0,n-1
	for l<=r {
		mid :=l+ (r - l) / 2
		if nums[mid] == target {
			return mid
		} else if nums[0] <= nums[mid] {
			if target >= nums[0] && target <= nums[mid] {
				r = mid - 1
			} else {
				l = mid + 1
			}
		} else {
			if target <= nums[n-1] && target > nums[mid] {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return  -1
}

func subsets(nums []int) (res[][]int) {
	var path []int
	var DFS func (index int)
	DFS= func(index int) {
		if index==len(nums) {
			res=append(res,append([]int{},path...))
			return
		}
		// 选当前位置
		path=append(path,nums[index])
		DFS(index+1)
		path=path[:len(path)-1] //拿掉 不选当前位置
		DFS(index+1)
	}
	DFS(0)
	return res
}

func permute(nums []int) (res [][]int) {
	var DFS func (nums []int ,index int,path []int)
	DFS=  func (nums []int ,index int,path []int) {
		if 0==len(nums) {
			p:=make([]int,len(path))
			copy(p,path)
			res=append(res,p)
			return
		}
		// 选当前位置
		for i:=0;i<len(nums) ;i++ {
			cur:=nums[i]
			path = append(path, cur)
			nums = append(nums[:i], nums[i+1:]...)
			DFS(nums, len(nums), path)
			nums = append(nums[:i], append([]int{cur}, nums[i:]...)...)
			path = path[:len(path)-1]
		}

	}
	DFS(nums,len(nums),[]int{})
	return res
}


func permuteII(nums []int) (res [][]int) {
	n:=len(nums)
	sort.Ints(nums)
	vis:=make([]bool,n)
	path:=[]int{}
	var DFS func(index int)
	DFS = func(index int) {
		if index == n {
			res = append(res, append([]int{}, path...))
			return
		}
		for i, v := range nums {
			if vis[i] || (i > 0 && !vis[i-1] && nums[i-1] != v) {
				continue
			}
			path = append(path, v)
			vis[i] = true
			DFS(index + 1)
			vis[i] = false
			path = path[:len(path)-1]
		}
	}

	DFS(0)
	return res
}

func maxSubArray(nums []int)  int {
	n:=len(nums)
	dp:=make([]int,n)
	dp[0]=nums[0]
	for i:=1;i<n ;i++  {
		if dp[i-1]>0 {
			dp[i]=dp[i-1]+nums[i]
		} else {
			dp[i]=nums[i]
		}
	}
	return  getMax(dp)
}


func jump (nums []int) int{
	n:=len(nums)
	if n==1 {
		return 0
	}
	dp:=make([]int,n)
	dp[0]=0
	dp[1]=1
	for i:=2;i<n ;i++{

		for j:=0;j<i ;j++  {
			min:=math.MaxInt32
			if nums[j]>=i-j {
				min= int(math.Min(float64(min), float64(dp[j]+1)))
			}
			dp[i]=min
		}
	}

	return dp[n-1]
}
func getMax(nums []int) int{
	max:=math.MinInt32
	for _,v:=range nums {
		if v>max {
			max=v
		}
	}
	return  max
}


func rotate(matrix [][]int)  {
	n:=len(matrix)
	// 水平线
	for i:=0;i<n/2 ;i++  {
		matrix[i], matrix[n-1-i] = matrix[n-1-i], matrix[i]
	}
	// 右对角线
	for i:=0;i<n ;i++  {
		for j:=0;j<i ;j++  {
			matrix[i][j],matrix[j][i]=matrix[j][i],matrix[i][j]}

	}
}

func reverseString(s []byte)  {
	n:=len(s)
	for l,r:=0,n-1;l<r ;l++ {
		s[l],s[r]=s[r],s[l]
		r--
	}
	fmt.Println(s)
}
func  main()  {

	s:=[]byte{'z','e','n','g','z'}


	reverseString(s)


}