package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2420_사파리월드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		System.out.println((Math.abs(N-M)));
		
	}

}
