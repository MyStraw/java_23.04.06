package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _6월17일_내일내일 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		// int n = Integer.parseInt(br.readLine());

		StringBuilder sbD = new StringBuilder();
		StringBuilder sbT = new StringBuilder();
		int n = sc.nextInt();
		List<Character> list = new LinkedList<>();

		int[] N = new int[31];

		for (int i = 0; i < n; i++) {
//			int d = Integer.parseInt(br.readLine());
//			int t = Integer.parseInt(br.readLine());
//			sbD.append(d);
//			sbT.append(t);
			int d = sc.nextInt();
			int t = sc.nextInt();
			for (int j = t; j > t - d; j--) {
				if (N[j] != 0) {
					t--;
				}
				N[j] = j;
			}
		}
		for (int i = 0; i < N.length; i++) {
			if (N[i] != 0) {
				System.out.println(i - 1);
				break;
			}
		}
	}
}
