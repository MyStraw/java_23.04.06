package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _2164_카드2 { //제출해
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			que.add(i);
		}

		while (que.size() != 1) {
			que.poll();
			que.add(que.poll());
		}
		bw.write(String.valueOf(que.peek()));
		bw.flush();
		bw.close();
	}
}
