package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _아레나B번_FizzBuzz2_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S1 = br.readLine();
		String S2 = br.readLine();
		String S3 = br.readLine();	

		String SS1 = S1;
		String SS2 = S2;
		String SS3 = S3;
		

		int Number4 = 0;

		String[] Pattern = { "int", "int", "Fizz", "int", "Buzz", "Fizz", "int", "int", "Fizz", "Buzz", "int", "Fizz",
				"int", "int", "FizzBuzz" };

				
		try {
			int Number1 = Integer.parseInt(S1);
			S1 = "int";
			Number4 = Integer.parseInt(SS1) + 3;
		} catch (Exception e) {
		}

		try {
			int Number2 = Integer.parseInt(S2);
			S2 = "int";
			Number4 = Integer.parseInt(SS2) + 2;
		} catch (Exception e) {
		}
		try {
			int Number3 = Integer.parseInt(S3);
			S3 = "int";
			Number4 = Integer.parseInt(SS3) + 1;
		} catch (Exception e) {
		}

		for (int i = 0; i <= Pattern.length - 3; i++) {
			if (Pattern[i].equals(S1) && Pattern[i + 1].equals(S2) && Pattern[i + 2].equals(S3)) {
				
				if (Pattern[(i + 3) % 15].equals("int") && Number4 % 3. != 0 && Number4 % 5 != 0) {
					System.out.println(Number4);
				} else  {
					System.out.println(Pattern[(i + 3) % 15]);
					break;
				}
			}
		}

	}
}
