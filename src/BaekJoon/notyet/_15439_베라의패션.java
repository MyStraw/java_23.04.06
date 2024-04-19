package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _15439_베라의패션 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(N * (N - 1));
	}
}
