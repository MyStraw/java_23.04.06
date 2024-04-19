package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2903_중앙이동알고리즘 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = (int) Math.pow(2, N) + 1;
		System.out.println((int)Math.pow(n, 2));
	}
}
