package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11365_밀비급일 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		while (true) {
			String secret = br.readLine();
			if (!secret.equals("END")) {
				char[] taetae = secret.toCharArray();
				for (int i = taetae.length - 1; i >= 0; i--) {
					System.out.print(taetae[i]);
				}
				System.out.println();
			} else {
				break;
			}
		}
	}
}
