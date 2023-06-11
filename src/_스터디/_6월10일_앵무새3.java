package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _6월10일_앵무새3 { // 배열로 풀기
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<String> listOfque[] = new LinkedList[N];
		Queue<String> result = new LinkedList<>();
		int count = 0;
		int loop = 0;

		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			Queue<String> que = new LinkedList<>();
			for (String s : S.split(" ")) {
				que.add(s);
			}
			listOfque[i] = que;
		}

		String sum = br.readLine();
		for (String s : sum.split(" ")) {
			result.add(s);
		}

		while (!result.isEmpty()) {
			if (loop > count) {
				break;
			}
			for (int i = 0; i < N; i++) {
				if (listOfque[i].isEmpty()) {
					continue;
				}
				if (listOfque[i].peek().equals(result.peek())) {
					listOfque[i].poll();
					result.poll();
					count++;
				}
			}
			loop++;
		}
		// 이거 추가. 배열도 마찬가지로~
		boolean empty = true;
		for (int i = 0; i < N; i++) {
			if (listOfque[i].isEmpty())
				empty = true;
			else
				empty = false;
			if (!empty) {
				break;
			}
		}

		if (result.isEmpty() && empty == true) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}
}
