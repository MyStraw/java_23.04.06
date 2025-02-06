package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3155_터널 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	
		int N = Integer.parseInt(br.readLine());

		
		int[] ceil = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ceil[i] = Integer.parseInt(st.nextToken());
		}

		
		int[] floor = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			floor[i] = Integer.parseInt(st.nextToken());
		}

		
		int[] path = new int[N];
		path[0] = 0;

		for (int i = 1; i < N; i++) {			
			path[i] = path[i - 1];			
			if (path[i] >= ceil[i]) {
				path[i] = ceil[i] - 1;
			}
			if (path[i] <= floor[i]) {
				path[i] = floor[i] + 1;
			}
		}
	
		for (int i = 0; i < N; i++) {
			bw.write(path[i] + " ");
		}
		bw.write("\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
