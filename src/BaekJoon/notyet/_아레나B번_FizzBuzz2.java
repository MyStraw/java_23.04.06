
package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _아레나B번_FizzBuzz2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String S1 = br.readLine();
		String S2 = br.readLine();
		String S3 = br.readLine();

		String SS1 = S1;
		String SS2 = S2;
		String SS3 = S3;

		String[] Pattern = { "int", "int", "Fizz", "int", "Buzz", "Fizz", "int", "int", "Fizz", "Buzz", "int", "Fizz",
				"int", "int", "FizzBuzz" };

		try {
			int Number1 = Integer.parseInt(S1);
			S1 = "int";
		} catch (Exception e) {
		}
		try {
			int Number2 = Integer.parseInt(S2);
			S2 = "int";
		} catch (Exception e) {
		}
		try {
			int Number3 = Integer.parseInt(S3);
			S3 = "int";
		} catch (Exception e) {
		}

		for (int i = 0; i <= Pattern.length - 3; i++) {
			if (Pattern[i].equals(S1) && Pattern[i + 1].equals(S2) && Pattern[i + 2].equals(S3)) {
				
				if (Pattern[(i + 3) % 15].equals("int")) {					
					if (S3.equals("int")) {
						System.out.println(Integer.parseInt(SS3) + 1);
						break;
					} else if (!S3.equals("int") && S2.equals("int")) {
						System.out.println(Integer.parseInt(SS2) + 2);
						break;
					} else if (!S3.equals("int") && !S2.equals("int") && S1.equals("int")) {
						System.out.println(Integer.parseInt(SS1) + 3);
						break;
					}
				} else if(!Pattern[(i + 3) % 15].equals("int")) {
					System.out.println(Pattern[(i + 3) % 15]);
					break;
				}
			}
		}
	}
}