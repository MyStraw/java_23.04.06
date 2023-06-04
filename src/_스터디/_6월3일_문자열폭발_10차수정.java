package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _6월3일_문자열폭발_10차수정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String moonjang = br.readLine();
		String bomb = br.readLine();
		Stack<Character> st = new Stack<>();
		Queue<Character> que = new LinkedList<>();
		Stack<Character> ts = new Stack<>();

		char[] moon = new char[moonjang.length()];
		char[] boom = new char[bomb.length()];

		// 4개짜리 탐침, 동그란 Que 순회모형. 하나씩 빠지면서. 맨앞 bomb.length길이만큼만 계속 재고 하나씩 빠져나가

		for (char d : moonjang.toCharArray()) {
			st.push(d);
			ts.push(st.pop());
//			que.add(ts.pop());
		}
		if (ts.size() >= bomb.length()) {
			boolean ilchi = true;
			for (int i = 0; i < bomb.length(); i++) {
				if (st.elementAt(st.size() - bomb.length() + i) != bomb.charAt(i)) {
					ilchi = false;
					break;

				}

			}
		}

	}

}
