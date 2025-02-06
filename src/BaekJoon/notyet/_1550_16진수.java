package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1550_16진수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String hex = br.readLine();
		int dec = Integer.parseInt(hex, 16);
		System.out.println(dec);
	}

}
