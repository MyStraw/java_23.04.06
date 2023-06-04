package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6월10일_북극곰은사람을찢어_1차수정 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		String bear = br.readLine();
		Stack<Character> st = new Stack<>();
		int count = 0;
		int day = 0;
		for (char ch : bear.toCharArray()) {
			st.push(ch);
			if (st.peek().toString().equals("(")) {
				count++;
			}

			else if (st.peek().toString().equals(")")) {
				count--;
			}

			if (Math.abs(count) > day) {
				day = Math.abs(count);
			}
		}
		if (count == 0) {
			System.out.println(day);
		} else

			System.out.println("-1");

	}

}
