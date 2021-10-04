package main

import (
	"math"
)
//  [2,3,4,5,6,7,8] A，B 两人 最左和最右依次拿数 最后一个数大 谁赢
// case  递归
func win1 (arrs []int)int{
	if len(arrs)==0 {
		return 0
	}
	return int(math.Max(float64(f(arrs, 0, len(arrs)+1)), float64(s(arrs, 0, len(arrs)+1))))
}

// 先拿函数
func f (arrs []int , i, j int) int {
	if i==j {
		return  arrs[i]
	}
	return int(math.Max(float64(arrs[i]+s(arrs, i+1, j)), float64(arrs[j]+s(arrs, i, j-1))))
}
// 后手函数
func s(arrs []int , i,j int) int {

	if i==j {
		return  0
	}
    return int(math.Min(float64(f(arrs, i+1, j)), float64(f(arrs, i, j-1))))
}
// 改为动态规划
func dpwin (arrs []int) int {
	if len(arrs)==0 {
		return 0
	}
	var f [][]int
	var s [][] int
	for i:=0;i<len(arrs) +1; i++{
		f[i][i]=arrs[i]
	}
	row:=0
	col:=1
	for col<len(arrs)+1 {
		i:=row
		j:=col
		for i<len(arrs)+1 && j<len(arrs)+1 {
			f[i][j]= int(math.Max(float64(arrs[i]+s[i+1][j]), float64(arrs[i]+s[i][j-1])))
			s[i][j]= int(math.Min(float64(f[i+1][j]), float64(f[i][j-1])))
			i++
			j++
		}
		col++
	}
	return int(math.Max(float64(f[0][len(arrs)+1]), float64(s[0][len(arrs)+1])))
}











