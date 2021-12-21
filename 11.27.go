package main

import (
	"fmt"
	"math"
)

func numSquares(n int) int {
	dp:=make([]int,n+1)

	for i:=1;i<=n ;i++  {
		curRes:=math.MaxInt32
		for j:=1;j*j<=i;j++ {
           curRes= int(math.Min(float64(curRes), float64(dp[i-j*j])))
		}
		dp[i]=curRes+1
	}
  return  dp[n]
}

func numSquares2(n int) int {
    var square []int
	for i:=1;i*i<=n ;i++  {
		square=append(square,i*i)
	}
	return coinChange(square,n)
}

func maximalSquare(matrix [][]byte) int {
	row:=len(matrix)
	col:=len(matrix[0])
	dp:=make([][]int,row)
	for i:=0;i<len(dp) ;i++  {
		dp[i]= make([]int,col)
	}
   res:=0
	for i:=0;i<row ;i++  {
		for j:=0;j<col ;j++  {
			dp[i][j]=int(matrix[i][j]-'0')
			if dp[i][j]==1 {
				res=1
			}
		}
	}

	for i:=1;i<row ;i++  {
		for j:=1;j<col;j++ {
			if dp[i][j]==1 {
				dp[i][j] = min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1
				if dp[i][j]>res {
					res=dp[i][j]
				}
			}
		}
	}
	fmt.Println(dp)
	return  res*res
}


func flatten(root *TreeNode)  {
	l:=inorder(root)
	for i:=0;i<len(l);i++ {
		prev, curr := l[i-1], l[i]
		prev.Left, prev.Right = nil, curr
	}

}
func inorder(root *TreeNode)   []*TreeNode{
	var l []*TreeNode
	if root!=nil {
		l=append(l,inorder(root)...)
		l=append(l,inorder(root.Left)...)
		l=append(l,inorder(root.Right)...)
			}

	return l
}


func exist(board [][]byte, word string) bool {

     rows,col:=len(board),len(board[0])
	visited:=make([][]bool,rows)
	for i:=0;i<rows;i++  {
		visited[i]=make([]bool,col)
	}

   var DFS func(r ,c ,i int) bool
	DFS= func(r, c, i int) bool {
		if i==len(word) {
			return true
		}
		if r<0||r>=rows||c<0||c>=col {
			return false
		}
		if visited[r][c]&&word[i]!=board[r][c] {
			return  false
		}
		visited[r][c]=true
         resSet:=DFS(r,c+1,i+1)||DFS(r,c-1,i+1)||DFS(r+1,c,i+1)||DFS(r-1,c,i+1)
		if resSet {
			return true
		} else {
			visited[r][c]=false
			return false
		}
	}

	for i:=0;i<rows ;i++  {
		for j:=0;j<col ;j++  {
			if board[i][j]==word[0]&&DFS(i,j,0) {
				return  true
			}
		}
	}

return  false

}

func countBits(n int) []int {
	res:=make([]int,n+1)
	for i:=range res {
         res[i]=f(i)
	}
    return  res
}

func f(i int) int{
	res:=0
	for ;i>0;i &= i-1  {
     res++
	}
	return  res
}
func min(a,b int) int{
	if a>b {
		return  b
	}
	return  a
}

func searchMatrix(matrix [][]int, target int) bool {
	rows, col := len(matrix), len(matrix[0])
	 x,y:=0,col-1
	for x<rows &&y>=0  {
		if matrix[x][y]==target {
			return true
		}
		if matrix[x][y]>target {
           y--
		} else {
         x++
		}
		}
	 return  false
}

func moveZeroes(nums []int)  {
	left, right, n := 0, 0, len(nums)
	for right < n {
		if nums[right] != 0 {
			nums[left], nums[right] = nums[right], nums[left]
			left++
		}
		right++
	}

   fmt.Println(nums)
}

func countSubstrings(s string) int {
	n := len(s)
	ans := 0
	for i := 0; i < 2 * n - 1; i++ {
		l, r := i / 2, i / 2 + i % 2
		for l >= 0 && r < n && s[l] == s[r] {
			l--
			r++
			ans++
		}
	}
	return ans
}

func diameterOfBinaryTree(root *TreeNode) int {
	ans:=0
	l:=dfs(root.Left,&ans)
	r:=dfs(root.Right,&ans)

	return int(math.Max(float64(ans), float64(l+r)))
}

func dfs(root *TreeNode ,in *int) (res int) {
	if root == nil {
		return 0
	}
	l := dfs(root.Left,in)
	r := dfs(root.Right,in)
	*in = int(math.Max(float64(*in), float64(l+r)))
	return int(math.Max(float64(l), float64(r)) + 1)
}

func isSymmetric(root *TreeNode) bool {
  return  check(root,root)
}

func check (l,r *TreeNode) bool{
	if l==nil&& r==nil{
		return  true
	}
	if l==nil|| r==nil{
		return  false
	}
	return l.Val==r.Val&&check(l.Left,r.Right)&&check(l.Right,l.Left)
}

func rob(nums []int) int {
	n:=len(nums)
	if n==0 {
		return 0
	}
	if n==1 {
		return nums[0]
	}
	dp:=make([]int,n)
	dp[0]=nums[0]
	dp[1]= max(nums[0],nums[1])
	for i:=2;i<n ;i++  {
		dp[i]=max(dp[i-2]+nums[i],dp[i-1])
	}
     return dp[n-1]
}

func max(a,b int) int  {
	if a>b {
		return a
	}
	return b
}

func longestConsecutive(nums []int) int {
	numSet := map[int]bool{}
	for _, num := range nums {
		numSet[num] = true
	}
	longestStreak := 0
	for num := range numSet {
		if !numSet[num-1] {
			currentNum := num
			currentStreak := 1
			for numSet[currentNum+1] {
				currentNum++
				currentStreak++
			}
			if longestStreak < currentStreak {
				longestStreak = currentStreak
			}
		}
	}
	return longestStreak
}




func f2(nums []int) int{
	nap :=make(map[int]bool,0)
	for _,num :=range nums  {
		nap[num]=true
	}
     res:=0
	for k, _:= range nap {
		if !nap[k-1] {
			cur:=k
			cures:=1
			for nap[cur+1]  {
				cur++
				cures++
			}
			if cures>res {
				res=cures
			}
		}
	}
	return  res
}

func f2(nums []int) int{
	nap :=make(map[int]bool,0)
	for _,num :=range nums  {
		nap[num]=true
	}
	res:=0
	for k, _:= range nap {
		if !nap[k-1] {
			cur:=k
			cures:=1
			for nap[cur+1]  {
				cur++
				cures++
			}
			if cures>res {
				res=cures
			}
		}
	}
	return  res
}

func invertTree(root *TreeNode) *TreeNode {
	if root==nil {
		return  nil
	}
	l:=invertTree(root.Left)
	r:=invertTree(root.Right)
	root.Left=r
	root.Right=l
	return root
}


func main(){
    b:=[]int{100,4,200,1,3,2}

	a:=f2(b)
   fmt.Println(a)

}