package _백준대회.대전과학고등학교_제1회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B번_그래프와그래프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		StringBuilder[] graph = new StringBuilder[11];
		for (int i = 1; i <= 10; i++) {
			graph[i] = new StringBuilder();
		}

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (A * x + B * y == C) {
					graph[x].append(y).append(" ");
				}
			}
		}

		for (int i = 1; i <= 10; i++) {
			if (graph[i].length() == 0) {
				System.out.println(0);
			} else {
				System.out.println(graph[i].toString());
			}
		}
	}

}
