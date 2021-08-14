package helloword.leetcode;

public class kekeEatBanana {
    public static int minEatSpeed(int[] piles, int h) {
        int left =1;
        int right =1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static int f(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed > 0) {
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {

    }

}