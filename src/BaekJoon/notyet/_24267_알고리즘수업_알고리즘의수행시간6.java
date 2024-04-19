package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _24267_알고리즘수업_알고리즘의수행시간6 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());		
		System.out.println(n*(n-1)*(n-2)/6);
		System.out.println(3);		
	}
}

// (n-2)(n-1)n / 3*2*1