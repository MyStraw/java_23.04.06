package _스터디;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _6월3일_프린터큐_1차수정 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Queue<Integer> testcase = new LinkedList<>();
		Queue<Integer> testcasecopy = new LinkedList<>();

		Scanner sc = new Scanner(System.in);

		int casenum = sc.nextInt();

		for (int i = 0; i < casenum; i++) {
			int max = 0;
			int count = 0;
			int N = sc.nextInt();
			int Nbae[] = new int[N];
			int M = sc.nextInt();
			for (int j = 0; j < N; j++) {
				int importance = sc.nextInt();
				testcase.add(importance);
				Nbae[j] = importance;
				if (max < Nbae[j]) {
					max = Nbae[j];
				}
			}
		}		
	}
}
