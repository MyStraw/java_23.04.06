package _스터디_자료구조;

import java.util.Scanner;

//10989번
public class _6_2_도수정렬2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int[] counts = new int[10 + 1];

		for (int i = 0; i < N; i++) {
			counts[sc.nextInt()]++;
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > 0) {
				for (int j = 0; j < counts[i]; j++) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.print(sb);
	}
}
