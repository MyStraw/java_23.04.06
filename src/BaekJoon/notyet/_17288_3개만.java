package BaekJoon.notyet;

import java.util.Scanner;

public class _17288_3개만 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		int count = 0;
		for (int i = 0; i < S.length() - 2; i++) {
			if (S.charAt(i + 1) == S.charAt(i) + 1 && S.charAt(i + 2) == S.charAt(i) + 2) {
				if (i + 3 >= S.length() || S.charAt(i + 3) != S.charAt(i) + 3) {
                    count++;                  
                    i += 2;
                } else {                    
                    while (i + 3 < S.length() && S.charAt(i + 3) == S.charAt(i) + 3) {
                        i++;
                    }
                }	
			}
		}		

		System.out.println(count);
	}
}
