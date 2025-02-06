package _백준대회.DGUPC_제2회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _B_팰린드롬판별2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
	
		String T = br.readLine();
		char[] arr = T.toCharArray();

		int pal = 0;
		
		for (int i = 0; i < N / 2; i++) {
			char left = arr[i];
			char right = arr[N - 1 - i];
		
			if (left != '?' && right != '?' && left != right) {
				System.out.println(0);
				return;
			}
		
			if (left == '?' || right == '?') {				
				if (left == '?' && right == '?') {
					pal += 26;
				}				
				else {
					pal += 1;
				}
			}
		}		

		System.out.println(pal);	
	}

}
