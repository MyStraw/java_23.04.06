package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24511_queuestack2 {

	static class QueueStack {
		int type;
		int value;

		public QueueStack(int type, int value) {
			this.type = type;
			this.value = value;
		}

		public int insertAndRemove(int newValue) {
			if (this.type == 0) {
				int oldValue = this.value;
				this.value = newValue;
				return oldValue;
			} else {
				return newValue;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		QueueStack[] queueStacks = new QueueStack[N];

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int type = Integer.parseInt(st.nextToken());
			queueStacks[i] = new QueueStack(type, 0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int initialValue = Integer.parseInt(st.nextToken());
			queueStacks[i].value = initialValue;
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int C = Integer.parseInt(st.nextToken());
			for (QueueStack qs : queueStacks) {
				C = qs.insertAndRemove(C);
			}
			sb.append(C + " ");
		}
		System.out.println(sb);
	}
}