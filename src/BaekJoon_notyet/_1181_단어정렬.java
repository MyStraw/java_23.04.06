package BaekJoon_notyet;

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
		System.out.println(aa[0]);		
	}
}
