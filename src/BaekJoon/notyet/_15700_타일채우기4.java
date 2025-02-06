package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15700_타일채우기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long N = Long.parseLong(input[0]);
		long M = Long.parseLong(input[1]);
		System.out.println((N * M) / 2);
	}

}
