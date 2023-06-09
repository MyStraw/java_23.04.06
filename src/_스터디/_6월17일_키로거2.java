package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _6월17일_키로거2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // 케이스 개수
		Stack<Character> keyloger = new Stack<>();
		Stack<Character> back = new Stack<>();
		Stack<Character> mouth = new Stack<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			keyloger.clear();
			mouth.clear();
			back.clear();		
			
//			char[] n = new char[str.length()];
//			n = str.toCharArray();
			
			for (int j = str.length() - 1; j >= 0; j--) {
				back.push(str.charAt(j));
			}
			while (!back.isEmpty()) {
				if (back.peek() != '<' && back.peek() != '>' && back.peek() != '-') {
					keyloger.push(back.pop());
				}
				if (back.isEmpty()) {
					break;
				}
				switch (back.peek()) {
				case '<':
					back.pop();
					if (!keyloger.isEmpty()) {
						mouth.push(keyloger.pop());
					}
					break;
				case '>':
					back.pop();
					if (!mouth.isEmpty())
						keyloger.push(mouth.pop());
					break;
				case '-':
					back.pop();
					if (!keyloger.isEmpty())
						keyloger.pop();
					break;
				}
			}
			if (back.isEmpty()) {
				while (!mouth.isEmpty()) {
					keyloger.push(mouth.pop());
				}
			}
			for (char c : keyloger) {
				bw.write(c);
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
////f<->--><-l>>d---u-j><>-<u->xb<<axkh<-wk>k>--t--s<b<i<ir>--ey>t>>sx<-yb<>jw<-qaruwy<osnshf><<<-uzz--<
//axwkieybtsbybqaruwosnuhfywx