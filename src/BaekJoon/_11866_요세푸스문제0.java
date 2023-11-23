package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			que.add(i);
		}

		StringBuffer sb = new StringBuffer("<");

		while (!que.isEmpty()) {
			for (int i = 0; i < K - 1; i++)
				que.add(que.poll());
			if (que.size() > 1)
				sb.append(que.poll() + ", ");
			else if (que.size() == 1)
				sb.append(que.poll());
		}

		sb.append(">");
		System.out.println(sb);

	}
}
