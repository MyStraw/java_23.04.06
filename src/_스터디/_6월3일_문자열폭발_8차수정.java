package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _6월3일_문자열폭발_8차수정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		Stack<String> st = new Stack<>();
		
		
		int count = 0;
		int cursor = 0;
		String splitmoonjang;

		for (char split : moonjang.toCharArray()) {
			st.push(Character.toString(split));
			if( st.peek() == Character.toString(bomb.charAt(bomb.length()))) {
				st.pop();
				st.pop();
			}
						
		}
	
	
		System.out.println(count);
	}
}
