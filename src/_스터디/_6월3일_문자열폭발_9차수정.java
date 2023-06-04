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
				for (int i = 0; i < bomb.length(); i++) { //항상 2개씩 돌게끔. 
					if (st.elementAt(st.size() - bomb.length() + i) != bomb.charAt(i)) { //elemenaAt, get이랑 같다. 알고싶은 위치의 글자가 뭔지. index 0번의 글자가 무슨 글자인지.
						ilchi = false; //st.size는 곧 push를 몇개 했냐는 소리. 3개 했다면 여기서 bomb 길이인 2개를 빼면... index 1부터 시작해서 그다음 글자까지.
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
