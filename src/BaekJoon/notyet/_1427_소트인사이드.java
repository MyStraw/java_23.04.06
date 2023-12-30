package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _1427_소트인사이드 { //comparator 은 char 못쓴다. Character 써야한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String bae = String.valueOf(N);

		//char[] naerim = bae.toCharArray();
		Character[] naerim = new Character[bae.length()];
		for (int i = 0; i<bae.length(); i++) {
			naerim[i] = bae.charAt(i);
		}		

		Arrays.sort(naerim, new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				return c2.compareTo(c1) ;
			}

		});
		
		for (Character c : naerim) {
			System.out.print(c);
		}

	}

}
