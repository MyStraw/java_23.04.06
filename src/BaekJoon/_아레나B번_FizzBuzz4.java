package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _아레나B번_FizzBuzz4 {

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S1 = br.readLine();
		String S2 = br.readLine();
		String S3 = br.readLine();

		String SS1 = S1;
		String SS2 = S2;
		String SS3 = S3;

		int Number4 = 0;
	

		if (isNumeric(S1)) {			
			Number4 = Integer.parseInt(SS1) + 3;
		}

		if (isNumeric(S2)) {			
			Number4 = Integer.parseInt(SS2) + 2;
		}

		if (isNumeric(S3)) {		
			Number4 = Integer.parseInt(SS3) + 1;
		}
		

		if (Number4 % 3 != 0 && Number4 % 5 != 0) {
			System.out.println(Number4);
			
		} else if (Number4 % 3 == 0 && Number4 % 5 == 0) {
			System.out.println("FizzBuzz");
			
		} else if (Number4 % 3 == 0 && Number4 % 5 != 0) {
			System.out.println("Fizz");
			
		} else if (Number4 % 3 != 0 && Number4 % 5 == 0) {
			System.out.println("Buzz");
			
		}

	}

}
