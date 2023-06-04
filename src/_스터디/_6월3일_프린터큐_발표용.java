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

		Queue<Point> test_point = new LinkedList<>(); //포인트 위치.
		Stack<Integer> reverse = new Stack<>(); //중요도 역순위해 딱 한번 사용
		Queue<Integer> imporeverse = new LinkedList<>(); //
		Scanner sc = new Scanner(System.in);

		int casenum = sc.nextInt();

		for (int i = 0; i < casenum; i++) {
			test_point.clear(); //클리어를 반드시 해줘야 한다.
			imporeverse.clear();
			reverse.clear();

			int count = 0;
			int N = sc.nextInt();

			int important[] = new int[N];
			int M = sc.nextInt();

			for (int j = 0; j < N; j++) {
				Point pp = new Point();
				int importance = sc.nextInt();				
				important[j] = importance;
	
				pp.x = importance;
				if (M == j) {
					pp.y = 100;
					test_point.add(pp);
				} else {
					pp.y = 0;
					test_point.add(pp);
				}
			}
			Arrays.sort(important);
			
			for (int k = 0; k < N; k++) {
				reverse.push(important[k]);
			}
			for (int k = 0; k < N; k++) {
				imporeverse.add(reverse.pop()); // testreverse 안에 역순이 들어있다. //point가 뺄거.
			}

			while (true) {
				if (imporeverse.peek() == test_point.peek().x) {
					if (100 == test_point.peek().y) {
						count++;
						System.out.println(count);
						break;
					}
					imporeverse.poll();
					test_point.poll();
					count++;

				} else if (imporeverse.peek() > test_point.peek().x) {
					test_point.add(test_point.poll());
				}
			}
		}
	}
}