package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _6월3일_문자열폭발_9차수정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		Stack<Character> st = new Stack<>();

		for (char split : moonjang.toCharArray()) {
			st.push(split);
			if (st.size() >= bomb.length()) {
				boolean ilchi = true;
				for (int i = 0; i < bomb.length(); i++) {
					if (st.elementAt(st.size() - bomb.length() + i) != bomb.charAt(i)) {
						ilchi = false;
						break;
					}
				}
				if (ilchi) {
					for (int j = 0; j < bomb.length(); j++) {
						st.pop();
					}
				}
			}
		}

		for (Character result : st) {
			bw.write(result);
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
