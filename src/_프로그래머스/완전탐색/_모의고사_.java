package _프로그래머스.완전탐색;

import java.util.ArrayList;
import java.util.List;

public class _모의고사_ {
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };

		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;

		for (int i = 0; i < answers.length; i++) {
			if (one[i % one.length] == answers[i]) {
				oneCount++;
			}
			if (two[i % two.length] == answers[i]) {
				twoCount++;
			}
			if (three[i % three.length] == answers[i]) {
				threeCount++;
			}
		}
		int max = Math.max(oneCount, Math.max(twoCount, threeCount));
		System.out.println(max);

		List<Integer> best = new ArrayList<>();
		
		if (max == oneCount) {
			best.add(1);
		}
		if (max == twoCount) {
			best.add(2);
		}
		if (max == threeCount) {
			best.add(3);
		}	

		int[] answer = new int[best.size()];
		for (int i = 0; i < best.size(); i++) {
			answer[i] = best.get(i);
		}			
		

	}

}
