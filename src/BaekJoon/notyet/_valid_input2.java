package BaekJoon.notyet;

import java.util.Scanner;

public class _valid_input2 {
	static class Node {
		String str;
		int[] arr;

		public Node() {
			this.str = "";
			this.arr = new int[]{1195462209, 1313164613, 84};			
		}
	}

	public static int wordSum(String str) {
		int sum = 0;
		for (int c = 0; c < str.length() && str.charAt(c) != ' '; c++) {
			sum += str.charAt(c) - 'a' + 1;
		}
		return sum;
	}

	public static boolean validateInput1(String str) {
		for (int c = 0; c < str.length(); c++) {
			if (str.charAt(c) < 'A' || str.charAt(c) > 'Z')
				return false;
		}
		return true;
	}

	public static boolean validateInput2(String str) {
		final String key = "TSFHHABP";
		final String hint = "\\BD_OBNZ";

		int prv = 0;
		for (int i = 0; i < 8; i++) {
			prv = ((prv << 1) ^ str.charAt(i)) & 31;
			if (prv + 'A' != key.charAt(i))
				return false;
		}

		for (int i = 0; i < 8; i++) {
			System.out.print((char) (str.charAt(i) ^ hint.charAt(i) & 31));
		}
		System.out.println();

		return true;
	}

	public static boolean validateInput3(int[] arr) {
		final String s1 = "computer preferred bulk tourist biographies";
		final String s2 = "worldwide resistance implemented magical viruses";
		final String s3 = "theorem";

		if (arr[0] != sentenceSum(s1))
			return false;
		if (arr[1] != sentenceSum(s2))
			return false;
		if (arr[2] != sentenceSum(s3))
			return false;

		return true;
	}

	public static int sentenceSum(String str) {
		int sum = 0;
		for (String word : str.split(" ")) {
			sum *= 100;
			sum += wordSum(word) % 100;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node data = new Node();

		data.str = sc.next();		

		if (!validateInput1(data.str)) {
			System.out.println("NO (1)");
			return;
		}
		if (!validateInput2(data.str)) {
			System.out.println("NO (2)");
			return;
		}

		if (!validateInput3(data.arr)) {
			System.out.println("NO (3)");
			return;
		}

		System.out.println("YES");
	}
}
//입력 = STAMINAM