package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스 수
		int T = Integer.parseInt(br.readLine());

		// 테스트 수만큼 돌리기
		for (int i = 0; i < T; i++) {
			// 함수 명령어 p
			String p = br.readLine();
			// 배열 개수 n
			int n = Integer.parseInt(br.readLine());
			// 배열안에 들어있는 숫자 파싱 [1,2,3] 형태
			String arrayNum = br.readLine();
			arrayNum = arrayNum.replace("[", "").replace("]", "");
			StringTokenizer st = new StringTokenizer(arrayNum, ",");
			// 덱 생성
			Deque<Integer> deque = new LinkedList<>();
			for (int j = 0; j < n; j++) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			}

			// 함수 명령어를 각각 배열에 분리
			char[] functions = p.toCharArray();
			// R뒤집기에 쓸 reverse
			boolean reverse = false;
			int reverseCount = 0;
			boolean D = false;

			for (char function : functions) {
				if (reverse == false) {
					if (function == 'R') {
						reverse = true;
						reverseCount++;
					} else if (function == 'D') {
						if (deque.isEmpty()) {
							D = true;
							break;
						} else {
							deque.pollFirst();
						}
					}
				} else if (reverse == true) {
					if (function == 'R') {
						reverse = false;
						reverseCount++;
					} else if (function == 'D') {
						if (deque.isEmpty()) {
							D = true;
							break;
						} else {
							deque.pollLast();
						}
					}
				}
			}
			if (D) {
				bw.write("error\n");
			} else {
				if (!deque.isEmpty()) {
					if (reverseCount % 2 == 0) {
						bw.write("[");
						int dequeSize = deque.size() - 1; // 이렇게 안하면 하나 poll 할때마다 size가 변동된다
						for (int k = 0; k < dequeSize; k++) {
							bw.write(String.valueOf(deque.pollFirst() + ","));
						}
						bw.write(String.valueOf(deque.pollFirst() + "]\n"));

					} else if (reverseCount % 2 == 1) {
						bw.write("[");
						int dequeSize = deque.size() - 1;
						for (int k = 0; k < dequeSize; k++) {
							bw.write(String.valueOf(deque.pollLast() + ","));
						}
						bw.write(String.valueOf(deque.pollLast() + "]\n"));
					}
				} else
					bw.write("[]\n");

			}

		}
		bw.flush();
		bw.close();

	}

}
