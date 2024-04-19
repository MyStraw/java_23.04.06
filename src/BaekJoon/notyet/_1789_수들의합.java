package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1789_수들의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long S = Long.parseLong(br.readLine());

		int total = 0;
		int count = 0;		

		for (int i = 1; total + i <= S; i++) {
			total += i;
			count++;			
		}
		System.out.println(count);
	}
}
