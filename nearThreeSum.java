package helloword.leetcode;

public class nearThreeSum {
    /* GoLang NSum
  *
func  twoSum(nums []int, target int) []int{
	left:=0
	right:=len(nums)-1
	var b []int
	for i := 0; i <right ;  {
		if left<=right {
			sum:=nums[left]+nums[right]
			if sum==target {
				b=append(b,left)
				b=append(b,right)
				return b
			} else if sum <target {
				left++
			} else if sum>target {
				right--
			}
		}
	}
	return b
}
func fourSum(nums []int,target int)(res [][]int ){
	var ans [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i - 1] {
			continue
		}
		for m := i+1; m <len(nums) ; m++ {
			if m > i+1 && nums[m] == nums[m - 1] {
				continue
			}
			j, k := m+ 1, len(nums) - 1
			for j < k{
				sum := nums[i] +nums[m]+ nums[j] + nums[k]
				if sum == target {
					// 找到值后 j++ k--
					ans = append(ans, []int{nums[i], nums[m],nums[j], nums[k]})
					j++
					k--
				} else if sum < target {
					// 排过序 < 0 j++
					j++
				} else {
					// >0  k--
					k--
				}
			}
		}
		}

	return ans

}

func threeSum(nums []int)(res [][]int)  {
	var ans [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		if i > 0 && nums[i] == nums[i - 1] {
			continue
		}
		j, k := i + 1, len(nums) - 1
		for j < i {
			if j > i + 1 && nums[j] == nums[j-1] {
				j++
				continue
			}
			if k < len(nums) - 1 && nums[k] == nums[k+1] {
				k--
				continue
			}
			sum := nums[i] + nums[j] + nums[k]
			if sum == 0 {
				// 找到值后 j++ k--
				ans = append(ans, []int{nums[i], nums[j], nums[k]})
				j++
				k--
			} else if sum < 0 {
				// 排过序 < 0 j++
				j++
			} else {
				// >0  k--
				k--
			}
		}
	}
	return ans
}
func nearThreeSum(nums []int,target int) (res [][]int) {
	ans:=make( map[float64][][]int,0)
	sort.Ints(nums)
	for i := 0; i < len(nums); i++ {
		j, k := i + 1, len(nums) - 1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			ans[math.Abs(float64(target-sum))] = append(ans[math.Abs(float64(target-sum))], []int{nums[i], nums[j], nums[k]})
			if sum == target {
				j++
				k--
			} else if sum < target {
				j++
			} else {
				k--
			}
		}
	}
	var key []float64
	for k, _ := range ans {
		key=append(key,k)
	}
	return ans[min(key)]
}
func min (nums []float64)(b float64){
	for _, n := range nums  {
		if b==0 || n<=b{
			b=n
		}
	}
	return b
}* */

}
