package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _6월17일_키로거3차 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int N = Integer.parseInt(br.readLine());
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for (int i = 0; i < N; i++) {
			String S = br.readLine();			
			left.clear();
			right.clear();			
			
			char[] moonja = new char[S.length()];
			moonja = S.toCharArray();


			for (char s : moonja) {
				if (s != '<' && s != '>' && s != '-') {
					left.push(s);
				}
				switch (s) {
				case '<':
					if (!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case '>':
					if (!right.isEmpty())
						left.push(right.pop());
					break;
				case '-':
					if (!left.isEmpty())
						left.pop();
					break;
				}
			}
			while (!right.isEmpty()) {
				left.push(right.pop());
			}
			for (char c : left) {
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