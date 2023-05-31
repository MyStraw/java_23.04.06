package _스터디;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class _6월3일_문자열폭발_6차수정 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String moonjang = sc.nextLine();
		String bomb = sc.nextLine();

		Stack<Character> st = new Stack<>();

		char[] split = new char[moonjang.toCharArray().length];
		
		for (char ch : moonjang.toCharArray()) {
			st.push(ch); 				
		}
		st.contains("ba");
		
		
		st.set(1, ' ');
		System.out.println(st);
		
		

//		for (int i = 0; i < moonjang.toCharArray().length; i++) {			
//
//		}

	}
}
