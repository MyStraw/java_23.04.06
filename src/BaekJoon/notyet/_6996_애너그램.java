package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6996_애너그램 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {		
			String[] str = br.readLine().split(" ");
			String A = str[0];
			String B = str[1];
		
			if (areAnagrams(A, B)) {
				System.out.println(A + " & " + B + " are anagrams.");
			} else {
				System.out.println(A + " & " + B + " are NOT anagrams.");
			}
		}
	}

	private static boolean areAnagrams(String A, String B) {	
		if (A.length() != B.length()) {
			return false;
		}
		
		char[] arrayA = A.toCharArray();
		char[] arrayB = B.toCharArray();

		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		return Arrays.equals(arrayA, arrayB); 
	}

}
