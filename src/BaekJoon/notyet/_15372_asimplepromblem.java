package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15372_asimplepromblem {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {		
			int N = Integer.parseInt(br.readLine());
		
			long K = (long) N * N;
			sb.append(K).append("\n");
		}
	
		System.out.print(sb.toString());
	}

}
