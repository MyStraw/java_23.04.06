package BaekJoon.notyet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _2246_콘도선정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<int[]> condos = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int distance = sc.nextInt();
			int cost = sc.nextInt();
			condos.add(new int[] { distance, cost });
		}

		condos.sort(Comparator.comparingInt(a -> a[0]));

		int minCost = 10001;
		int result = 0;

		for (int[] condo : condos) {
			if (condo[1] < minCost) {
				minCost = condo[1];
				result++;
			}
		}

		System.out.println(result);		
	}

}
