package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1718_암호 {	
	private static int alphaToNum(char c) {
		return c - 'a';
	}

	private static char numToAlpha(int n) {
		return (char) (n + 'a');
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String txt = br.readLine();
		String key = br.readLine();
		
		StringBuilder sb = new StringBuilder();
	
		for (int i = 0; i < txt.length(); i++) {
			char plainChar = txt.charAt(i);

			if (plainChar == ' ') {				
				sb.append(' ');
			} else {				
				int plainCharPos = alphaToNum(plainChar);
				int keyCharPos = alphaToNum(key.charAt(i % key.length()));				
				int newCharPos = plainCharPos - keyCharPos - 1;
			
				if (newCharPos < 0) {
					newCharPos += 26;
				}
				
				sb.append(numToAlpha(newCharPos));
			}
		}
		System.out.println(sb.toString());
	}
}
