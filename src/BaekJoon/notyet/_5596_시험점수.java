package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5596_시험점수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
	
		int minTotal = 0;
		for (int i= 0; i<4; i++) {
			minTotal += Integer.parseInt(st.nextToken());
		}		
		
		st = new StringTokenizer(br.readLine());
		
		int manTotal = 0;
		for (int i= 0; i<4; i++) {
			manTotal += Integer.parseInt(st.nextToken());
		}
		
		if (minTotal >= manTotal) {
			System.out.println(minTotal);
		}
		else {
			System.out.println(manTotal);
		}
				
	}

}
