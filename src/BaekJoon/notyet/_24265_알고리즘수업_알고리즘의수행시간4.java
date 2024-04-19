package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _24265_알고리즘수업_알고리즘의수행시간4 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());		
		System.out.println((n*(n-1))/2);
		System.out.println(2);		
	}
}
