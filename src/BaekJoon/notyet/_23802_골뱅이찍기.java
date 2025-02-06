package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23802_골뱅이찍기 {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		int width = 5 * N; 
		int height = 5 * N; 
	
		StringBuilder sb = new StringBuilder();
	
		for (int i = 0; i < N; i++) {
			sb.append("@".repeat(width)).append("\n");
		}
	
		for (int i = 0; i < 4 * N; i++) {
			sb.append("@".repeat(N)).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
