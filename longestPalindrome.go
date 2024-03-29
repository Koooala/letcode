package main

import (
	"fmt"
	"math"
	"sort"
	"strconv"
	"strings"
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


func deleteNode(node *ListNode) {
	node.Val=node.Next.Val
	node.Next=node.Next.Next

}

func isPowerOfTwo(n int) bool {
	if n==0 {
		return true
	}
	if n&(n-1)==0 {
		return true
	}
	return false
}

func merge(nums1 []int, m int, nums2 []int, n int)  {
	copy(nums1[m:], nums2)
	sort.Ints(nums1)
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



func maxProfit(prices []int) int {
	ans := 0
	sum := 0
	for i := 1; i < len(prices); i++ {
		sum += prices[i] - prices[i - 1]
		ans =int(math.Max(float64(ans), float64(sum)))
		if sum <0{
			sum=0
		}
	}
	return ans
}
func detectCycle(head *ListNode) *ListNode {
	// 流程： 快慢指针快跑两步，慢跑一步,当相等时候,再找个指针p从头点和慢指针一起跑，相等时候就是环点
	s,f:=head,head
	for f!=nil  {
		s=s.Next
		if f.Next==nil {
			return nil
		}
		f=f.Next.Next
		if f==s {
			p:=head
			for p != s {
				p = p.Next
				s = s.Next
			}
			return p
		}
	}
	return nil
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	//  双指针
	for curr != nil {
		// 调整局部
		next := curr.Next
		curr.Next = prev
		// 移动双指针
		prev = curr
		curr = next
	}
	return prev

}

func singleNumber(nums []int) int {
	s:=0
	for _,r:=range nums {
		s^=r
	}
	return s

}
func isPerfectSquare(num int) bool {
	if num<=0{
		return true
	}
	l,r:=1,num/2
	for l<r {
		mid:=l+(r-l+1)/2
		x:=mid*mid
		if x==num {
			return true
		}
		if x<num {
			l=mid
		}else {
			r=mid-1
		}
	}
	return false

}
func productExceptSelf(nums []int) []int {
	l:=make([]int,len(nums))
	l[0]=1
	for i:=1;i<len(nums) ;i++  {
		l[i]=l[i-1]*nums[i-1]
	}
	r:=make([]int,len(nums))
	r[len(nums)-1]=1
	for i:=len(nums)-2;i>=0 ;i--  {
		r[i]=r[i+1]*nums[i+1]
	}
	ans:=make([]int,len(nums))

	for i:=0;i<len(nums) ;i++  {
		ans[i]=l[i]*r[i]
	}
	return ans

}
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	res:=root
	for  {
		if p.Val<res.Val&&q.Val<res.Val {
			res=res.Left
		} else if  p.Val>res.Val&&q.Val>res.Val {
			res=res.Right
		} else {
			return res
		}
	}
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head==nil||k==0||head.Next==nil {
		return head
	}
	length:=1
	p:=head
	// 找到最后一个节点
	for p.Next!=nil  {
		p=p.Next
		length++
	}
	// 连接成环
	p.Next=head
	// 找到要断开的位置
	steps:=length-k%length
	for steps>0  {
		p=p.Next
		steps--
	}
	newHead:=p.Next
	p.Next=nil
	return newHead
}

func reverseWords(s string) string {
	list:=strings.Split(s," ")
	var res string
	for i, l := range list {
		temp:=reverse(l)
		space:=" "
		if i==len(list)-1 {
			res=res+temp
		} else {
			res=res+temp+space
		}

	}
	return res
}

func reverseWords2(s string) string {
	/*	length := len(s)
		ret := []byte{}
		for i := 0; i < length; {
			start := i
			// 找到空格处
			for i < length && s[i] != ' ' {
				i++
			}
			// 挨个反转
			for p := start; p < i; p++ {
				ret = append(ret, s[start + i - 1 - p])
			}
			// 末位添加空格
			for i < length && s[i] == ' ' {
				i++
				ret = append(ret, ' ')
			}
		}
		return string(ret)*/
	return ""
}


func  reverse(l string) string{
	n:=len(l)
	s:=[]rune(l)
	for l,r:=0,n-1;l<r ;l++ {
		s[l],s[r]=s[r],s[l]
		r--
	}
	return string(s)
}

func containsDuplicate(nums []int) bool {
	mp:=make(map[int]struct{},0)
	for _,n:=range nums {
		if _,ok:=mp[n];ok {
			return true
		}
		mp[n]= struct{}{}
	}
	return false


	/*sort.Ints(nums)
	for i:=1;i<len(nums);i++ {
		if nums[i]==nums[i-1] {
			return true
		}
	}
return false*/
}



type LRUCache struct {
	size int
	capacity int
	cache map[int]*DLinkedNode
	head, tail *DLinkedNode
}

type DLinkedNode struct {
	key, value int
	prev, next *DLinkedNode
}

func initDLinkedNode(key, value int) *DLinkedNode {
	return &DLinkedNode{
		key: key,
		value: value,
	}
}

func Constructor(capacity int) LRUCache {
	l := LRUCache{
		cache: map[int]*DLinkedNode{},
		head: initDLinkedNode(0, 0),
		tail: initDLinkedNode(0, 0),
		capacity: capacity,
	}
	l.head.next = l.tail
	l.tail.prev = l.head
	return l
}

func (l *LRUCache) Get(key int) int {
	if _, ok := l.cache[key]; !ok {
		return -1
	}
	node := l.cache[key]
	l.moveToHead(node)
	return node.value
}


func (l *LRUCache) Put(key int, value int)  {
	if _, ok := l.cache[key]; !ok {
		node := initDLinkedNode(key, value)
		l.cache[key] = node
		l.addToHead(node)
		l.size++
		if l.size > l.capacity {
			removed := l.removeTail()
			delete(l.cache, removed.key)
			l.size--
		}
	} else {
		node := l.cache[key]
		node.value = value
		l.moveToHead(node)
	}
}

func (l *LRUCache) addToHead(node *DLinkedNode) {
	node.prev = l.head
	node.next = l.head.next
	l.head.next.prev = node
	l.head.next = node
}

func (l *LRUCache) removeNode(node *DLinkedNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
}

func (l *LRUCache) moveToHead(node *DLinkedNode) {
	l.removeNode(node)
	l.addToHead(node)
}

func (l *LRUCache) removeTail() *DLinkedNode {
	node := l.tail.prev
	l.removeNode(node)
	return node
}

func majorityElement(nums []int) int {
	count:=1
	maj:=nums[0]
	for i:=1;i<len(nums) ;i++  {
		if nums[i]==maj {
			count++
		} else {
			count--
			if count==0 {
				maj=nums[i+1]
			}
		}
	}
	return  maj

}

func m(s1 ,s2 string) string  {
	if s1=="0"||s2=="0" {
		return  "0"
	}
	l1,l2:=len(s1),len(s2)
	res:=make([]int,l1+l2)

	for i:=l1-1; i>=0;i--  {
		x:=int(s1[i]-'0')
		for j:=l2-1;j>=0 ;j--  {
			y:=int(s2[j]-'0')
			res[i+j+1]= res[i+j+1]+ x*y
		}
	}
	// res:= 0 2 7 16 17 12

	// 处理大于10的部分 向前进位
	for i:=l2+l1-1;i>0 ;i--  {
		res[i-1]=res[i-1]+res[i]/10
		res[i]=res[i]%10
	}
	// res:=0 2 8 7 8 2
	// 从不等于0的地方开始
	index:=0
	if res[0]==0 {
		index=1
	}
	ans:=""
	for ;index<l1+l2 ;index++  {
		ans=ans+strconv.Itoa(res[index])
	}
	return  ans
}

func ser(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}
	rows,columns:=len(matrix),len(matrix[0])
	left,top,right,bottom:=0,0,columns-1,rows-1
	res:=make([]int,rows*columns)
	index:=0
	for left<=right&&bottom>=top {
		// (top,left) -> (top,right)
		for i:=left;i<=right ;i++  {
			res[index]=matrix[top][i]
			index++
		}
		//	(top+1,right) -> (bottom,right)
		for i:=top+1;i<=bottom ;i++  {
			res[index]=matrix[i][right]
			index++
		}

		if left<right&&top<bottom {
			//	(bottom,right-1) -> (bottom,left+1)
			for i:=right-1;i>left ;i--  {
				res[index]=matrix[bottom][i]
				index++
			}
			// 	//	(bottom,left) -> (top+1,left)
			for i:=bottom;i>top ;i--  {
				res[index]=matrix[i][left]
				index++
			}
		}
		top++
		left++
		right--
		bottom--
	}
	return res
}


