package BaekJoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class _1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		HashSet<String> hash = new HashSet<>();		
		
		for (int i = 0; i<N; i++) {
			String A = sc.next();
			hash.add(A);			
		}		
		String[] aa = new String[hash.size()];		
		hash.toArray(aa);
		Arrays.sort(aa);
		Arrays.sort(aa, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		for (int i = 0 ; i<aa.length; i++) {
			System.out.println(aa[i]);
		}
	}
}
