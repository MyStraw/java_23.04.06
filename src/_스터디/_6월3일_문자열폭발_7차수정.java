package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6월3일_문자열폭발_7차수정 {

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
		}
		st.elementAt(1); // 스택에 2번재에 있는 글자는 뭔가
		moonjang.charAt(1); // 문장에 2번째에 있는 글자는 뭔가
		for (int i = 0; i < moonjang.length() - 1; i++) {
			splitmoonjang = "";
			for (int j = i; j < i + bomb.length(); j++) {
				splitmoonjang += st.elementAt(j);
				cursor = j - bomb.length() + 1;
			}
			if (splitmoonjang.equals(bomb)) {
				count++;
			}
		}

		System.out.println(count);
	}
}
