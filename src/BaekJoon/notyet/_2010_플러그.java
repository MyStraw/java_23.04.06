package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2010_플러그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		for (int i = 0; i < n; i++) {
			int plugs = Integer.parseInt(br.readLine());
			total += plugs;
		}
		System.out.println(total - (n - 1));
	}

}
