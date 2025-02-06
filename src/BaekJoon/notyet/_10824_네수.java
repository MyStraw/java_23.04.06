package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10824_네수 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		String A = input[0];
		String B = input[1];
		String C = input[2];
		String D = input[3];
		
		String AB = A + B;
		String CD = C + D;
		
		long sum = Long.parseLong(AB) + Long.parseLong(CD);
	
		System.out.println(sum);
	}

}
