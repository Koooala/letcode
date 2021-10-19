package main

// 获取最长有效括号子串
func getMaxSubKuoHao (str string) int {
	dp:=make([]int,len(str))
	for i := 1; i <len(str) ; i++ {
		if str[i]==')' {
			if str[i-1]=='(' {
				if i>2 {
					dp[i]=dp[i-2]+2
				} else {
					dp[i]=2
				}
			} else if i-dp[i-1]>0 && str[i-dp[i-1]-1]=='(' {
				if  i-dp[i-1]>2{
					dp[i]= dp[i-1]+dp[i-dp[i-1]-2]+2
				} else {
					dp[i]=dp[i-1]+2
				}
			}
		}}

	return  maxVale(dp)
}

func maxVale(arrs []int ) int{
	ans:=0
	for _, a := range arrs {
		if a>ans {
			ans=a
		}
	}
	return ans
}