package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5358_Football_Team {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		while (!br.equals("")) {

			char[] charr = br.readLine().toCharArray();

			for (int i = 0; i < charr.length; i++) {
				if (charr[i] == 'i') {
					charr[i] = 'e';
					continue;
				} else if (charr[i] == 'e') {
					charr[i] = 'i';
					continue;
				}
			}
			System.out.println(charr);			
		}		
	}
}