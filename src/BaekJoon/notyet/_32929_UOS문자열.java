package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _32929_UOS문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long x = Long.parseLong(br.readLine());
		char[] uos = { 'U', 'O', 'S' };
		System.out.println(uos[(int) ((x - 1) % 3)]);
	}

}
