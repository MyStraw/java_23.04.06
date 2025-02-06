package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17863_FYI {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String phoneNumber = br.readLine();

		String prefix = phoneNumber.substring(0, 3);

		if (prefix.equals("555")) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
