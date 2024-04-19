package _코테준비_;

import java.util.Arrays;
import java.util.List;

public class 아_동적계획법_4 {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
				Arrays.asList(4, 1, 8, 3));
		System.out.println("최대 경로 합: " + minimumTotal(triangle));
	}

}

//입력: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//출력: 최대 경로 합: 11