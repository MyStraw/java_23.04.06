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
		Stack<Character> st = new Stack<>();
		

		for (char ch : moonjang.toCharArray()) {
			st.push(ch);

			if (st.size() >= bomb.length()) {
				boolean matches = true;
				for (int i = 0; i < bomb.length(); i++) {
					if (st.get(st.size() - bomb.length() + i) != bomb.charAt(i)) {
						matches = false;
						break;
					}
				}

				if (matches) {
					for (int i = 0; i < bomb.length(); i++) {
						st.pop();
					}
				}
			}
		}
		System.out.println(st);
	}
}
