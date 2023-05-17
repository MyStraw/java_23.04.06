package study;

import java.util.Scanner;

public class _5_3_문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0; i<N; i++) {
			String st = sc.next();
			System.out.print(st.charAt(0));
			System.out.println(st.charAt(st.length()-1));		
		}		
	}
}
