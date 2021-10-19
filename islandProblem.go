package main

import "math"

//
func islands_one(grid [][]byte) int{
	n,m:=len(grid),len(grid[0])
	res:=0
     var DFS  func(girds [][]byte,i,j int)
	 DFS= func(girds [][]byte, i, j int) {
		 if i<0||j<0||i>=n||j>=m {
			 return
		 }
		 if girds[i][j]=='0' {
			 return
		 }
		 girds[i][j]='0'
         DFS(girds,i,j-1)
		 DFS(girds,i,j+1)
		 DFS(girds,i-1,j)
		 DFS(girds,i+1,j)
	 }
	for i := 0; i <n ; i++ {
		for j := 0; j <m ; j++ {
			if grid[i][j]=='1'{
				res++
				DFS(grid,i,j)
			}
		}
	}
    return  res
}

// 去掉边界的
func islands_two (grid [][]int) int {
	n,m:=len(grid),len(grid[0])
	res:=0
	var DFS  func(girds [][]int,i,j int)
	DFS= func(girds [][]int, i, j int) {
		if i<0||j<0||i>=n||j>=m {
			return
		}
		if girds[i][j]==0 {
			return
		}
		girds[i][j]=0
		DFS(girds,i,j-1)
		DFS(girds,i,j+1)
		DFS(girds,i-1,j)
		DFS(girds,i+1,j)
	}

	for i := 0; i <n ; i++ {
		DFS(grid,i,0)
		DFS(grid,i,m-1)
	}
	for j:= 0; j < m; j++ {
		DFS(grid,0,j)
		DFS(grid,n-1,j)
	}
	for i := 0; i <n ; i++ {
		for j := 0; j <m ; j++ {
			if grid[i][j]==1{
				res+=1
                DFS(grid,i,j)
			}
		}
	}
	return  res
}

// 计算 最大值
func islands_three (grid [][]int) int {
	n,m:=len(grid),len(grid[0])
	res:=0
	var DFS  func(girds [][]int,i,j int) int
	DFS= func(girds [][]int, i, j int) int {
		if i<0||j<0||i>=n||j>=m {
			return 0
		}
		if girds[i][j]==0 {
			return 0
		}
		girds[i][j]=0
		return DFS(girds,i,j-1)+
		DFS(girds,i,j+1)+
		DFS(girds,i-1,j)+
		DFS(girds,i+1,j)+1
	}
	for i := 0; i <n ; i++ {
		for j := 0; j <m ; j++ {
			if grid[i][j]==1{
				res=int(math.Max(float64(res),float64(DFS(grid,i,j))))
			}
		}
	}
	return  res
}

func islands_four (girds1 [][]int,girds2 [][]int) int {
	n,m:=len(girds1),len(girds1[0])
	res:=0
	var DFS  func(girds [][]int,i,j int)
	DFS= func(girds [][]int, i, j int) {
		if i<0||j<0||i>=n||j>=m {
			return
		}
		if girds[i][j]==0 {
			return
		}
		girds[i][j]=0
		DFS(girds,i,j-1)
		DFS(girds,i,j+1)
		DFS(girds,i-1,j)
		DFS(girds,i+1,j)
	}

	for i := 0; i <n ; i++ {
		for j:= 0; j < m; j++ {
			if girds1[i][j]==0&& girds2[i][j]==1 {
               DFS(girds2,i,j)
			}
		}
	}

	for i := 0; i <n ; i++ {
		for j := 0; j <m ; j++ {
			if girds1[i][j]==1{
				res++
				DFS(girds2,i,j)

			}
		}
	}
	return  res
}