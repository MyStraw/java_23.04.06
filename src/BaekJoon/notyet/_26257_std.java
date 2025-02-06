package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _26257_std {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] pointer = new int[M + 1];
		int[] refCount = new int[N + 1];

		for (int i = 1; i <= M; i++) {
			int obj = Integer.parseInt(br.readLine());
			pointer[i] = obj;
			if (obj > 0)
				refCount[obj]++;
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int x = Integer.parseInt(st.nextToken());

			if (op.equals("assign")) {
				int y = Integer.parseInt(st.nextToken());
				if (pointer[x] > 0)
					refCount[pointer[x]]--;
				pointer[x] = pointer[y];
				if (pointer[x] > 0)
					refCount[pointer[x]]++;
			} else if (op.equals("swap")) {
				int y = Integer.parseInt(st.nextToken());
				int temp = pointer[x];
				pointer[x] = pointer[y];
				pointer[y] = temp;
			} else if (op.equals("reset")) {
				if (pointer[x] > 0)
					refCount[pointer[x]]--;
				pointer[x] = 0;
			}
		}

		List<Integer> object = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (refCount[i] > 0)
				object.add(i);
		}

		bw.write(object.size() + "\n");
		for (int obj : object) {
			bw.write(obj + "\n");
		}
		bw.flush();
		bw.close();

	}

}
