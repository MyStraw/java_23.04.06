package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7월1일_야구게임3 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
		for (int i = 100; i <= 999; i++) {
			if (Integer.toString(i).charAt(0) != Integer.toString(i).charAt(1)
					&& Integer.toString(i).charAt(1) != Integer.toString(i).charAt(2)
					&& Integer.toString(i).charAt(0) != Integer.toString(i).charAt(2)
					&& Integer.toString(i).charAt(1) != '0' && Integer.toString(i).charAt(2) != '0') {
				que.add(i);
			}
		}		

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String num = st.nextToken();
			char[] baseball = new char[3];
			baseball = num.toCharArray();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			
			for (int c : que) {
				int strikecount = 0;
				int ballcount = 0;
				if (Integer.toString(c).charAt(0) == num.charAt(0)) {
					strikecount++;
				}
				if (Integer.toString(c).charAt(1) == num.charAt(1)) {
					strikecount++;
				}
				if (Integer.toString(c).charAt(2) == num.charAt(2)) {
					strikecount++;
				}				
				if (Integer.toString(c).charAt(0) == num.charAt(1)) {
					ballcount++;
				}
				if (Integer.toString(c).charAt(0) == num.charAt(2)) {
					ballcount++;
				}
				if (Integer.toString(c).charAt(1) == num.charAt(0)) {
					ballcount++;
				}
				if (Integer.toString(c).charAt(1) == num.charAt(2)) {
					ballcount++;
				}
				if (Integer.toString(c).charAt(2) == num.charAt(0)) {
					ballcount++;
				}				
				if (Integer.toString(c).charAt(2) == num.charAt(1)) {
					ballcount++;
				}
				
				if (strike == strikecount && ball == ballcount) {
					que2.add(c);
				}				
			}
			
			
			
			
		}
		bw.write(String.valueOf(que2.size()));
		bw.flush();
		bw.close();
	}
}
