package BaekJoon.notyet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2822_점수계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Score> scores = new ArrayList<>();

		for (int i = 1; i <= 8; i++) {
			int score = sc.nextInt();
			scores.add(new Score(score, i));
		}

		Collections.sort(scores, (s1, s2) -> s2.score - s1.score);

		int totalScore = 0;
		List<Integer> selectedProblems = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Score info = scores.get(i);
			totalScore += info.score;
			selectedProblems.add(info.problemNumber);
		}

		Collections.sort(selectedProblems);

		System.out.println(totalScore);
		for (int problemNumber : selectedProblems) {
			System.out.print(problemNumber + " ");
		}
		System.out.println();
	}

	static class Score {
		int score;
		int problemNumber;

		Score(int score, int problemNumber) {
			this.score = score;
			this.problemNumber = problemNumber;
		}
	}

}
