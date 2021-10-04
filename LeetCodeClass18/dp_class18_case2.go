package main

// case 2   象棋上 马从（0，0）跳K步到（x,y）点有多少种跳法
func jump(x,y,k int) int {
	if x<0|| x>8 || y<0||y>9 {
		return 0
	}
	if k==0 {
		if x==0&&y==0 {
			return 1
		}
		return 0
	}
	// 等于x,y 点周围八个点之和
	return jump(x-1,y+2,k-1)+
		jump(x+1,y+2,k-1)+
		jump(x+2,y+1,k-1)+
		jump(x+2,y-1,k-1)+
		jump(x+1,y-2,k-1)+
		jump(x-1,y-2,k-1)+
		jump(x-2,y-1,k-1)+
		jump(x-2,y+1,k-1)
}
// 改为动态 规划

func dpJump (x,y,k int) int   {

	var dp [][][]int
	if x<0|| x>8 || y<0||y>9|| k<0 {
		return 0
	}
	dpp[0][0][0]=1

	for h:=1;h<=k ;h++  {
		for r:=0 ;r<9 ;r++  {
			for l:=0;l<10 ;l++  {
				// 根据上面递归关系填值
				dp[r][l][h]=getValue(dp,r-1,l+2,h-1)
				dp[r][l][h]=getValue(dp,r+1,l+2,h-1)
				dp[r][l][h]=getValue(dp,r+2,l+1,h-1)
				dp[r][l][h]=getValue(dp,r+2,l-1,h-1)
				dp[r][l][h]=getValue(dp,r+1,l-2,h-1)
				dp[r][l][h]=getValue(dp,r-1,l-2,h-1)
				dp[r][l][h]=getValue(dp,r-2,l-1,h-1)
				dp[r][l][h]=getValue(dp,r-2,l+1,h-1)
			}
		}
	}
	return dp[x][y][k]
}

func  getValue( dp [][][]int,row,col,step int) int {
	if row<0||row>8||col<0||col>9 {
		return 0
	}
	return dp[row][col][step]

}






