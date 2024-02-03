package BaekJoon.notyet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class _1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		Set<String> words = new HashSet<>(); 
		for (int i = 0; i < N; i++) {
			words.add(sc.nextLine().trim());
		}

		List<String> sort = new ArrayList<>(words);
		Collections.sort(sort, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				}				
				return s1.compareTo(s2);
			}
		});
		
		for (String word : sort) {
			System.out.println(word);
		}
	}

}
