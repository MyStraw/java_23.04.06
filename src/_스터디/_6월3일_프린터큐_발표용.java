package _스터디;

import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class _6월3일_프린터큐_발표용 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Queue<Integer> testcase = new LinkedList<>(); //이건 케이스
		Queue<Point> point = new LinkedList<>(); //포인트 위치.
		Stack<Integer> reverse = new Stack<>(); //중요도 역순위해 딱 한번 사용
		Queue<Integer> testreverse = new LinkedList<>(); //
		Scanner sc = new Scanner(System.in);

		int casenum = sc.nextInt();

		for (int i = 0; i < casenum; i++) {
			point.clear();
			testcase.clear();
			testreverse.clear();
			reverse.clear();

			int count = 0;
			int N = sc.nextInt();
			int Nbae[][] = new int[N][2]; //탐침을 붙인다.
			int important[] = new int[N];
			int M = sc.nextInt();

			for (int j = 0; j < N; j++) {
				Point pp = new Point();
				int importance = sc.nextInt();

				important[j] = importance;
				testcase.add(Nbae[j][0]);
				pp.x = importance;
				if (M == j) {
					pp.y = 100;
					point.add(pp);
				} else {
					pp.y = 0;
					point.add(pp);
				}

			}
			Arrays.sort(important);
			for (int k = 0; k < N; k++) {
				reverse.push(important[k]);
			}
			for (int k = 0; k < N; k++) {
				testreverse.add(reverse.pop()); // testreverse 안에 역순이 들어있다. //point가 뺄거.
			}

			while (!testcase.isEmpty()) {
				if (testreverse.peek() == point.peek().x) {
					if (100 == point.peek().y) {
						count++;
						System.out.println(count);
						break;
					}
					testreverse.poll();
					point.poll();
					count++;

				} else if (testreverse.peek() > point.peek().x) {
					point.add(point.poll());
				}
			}
		}
	}
}