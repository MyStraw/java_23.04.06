package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6월24일_참외밭3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int melon[][] = new int[6][2];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> que = new LinkedList<>();
		int K = Integer.parseInt(br.readLine());

		int seroTotal = 0;
		int seroMax = 0;
		int garoTotal = 0;
		int garoMax = 0;		

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int compass = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			melon[i][0] = compass;
			melon[i][1] = length;

			if (melon[i][0] == 3 | melon[i][0] == 4) {
				seroTotal += melon[i][1];
			}
			if (melon[i][0] == 1 | melon[i][0] == 2) {
				garoTotal += melon[i][1];
			}
			que.add(length);
		}
		seroMax = seroTotal / 2;
		garoMax = garoTotal / 2;

		int lastIndex = 0;

		for (int i = 0; i < 5; i++) {
			if ((melon[i][1] == seroMax & melon[i + 1][1] == garoMax)
					|| (melon[i][1] == garoMax & melon[i + 1][1] == seroMax)) {
				lastIndex = i + 1;
			}
		}
		if ((melon[5][1] == seroMax & melon[0][1] == garoMax) || (melon[5][1] == garoMax & melon[0][1] == seroMax)) {
			lastIndex = 0;
		}

		if (lastIndex != 5) {
			for (int i = 0; i < lastIndex + 1; i++) {
				que.add(que.poll());
			}
		}
		
		que.poll();
		
		int result = (seroMax * garoMax - que.poll() * que.peek()) * K;
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
