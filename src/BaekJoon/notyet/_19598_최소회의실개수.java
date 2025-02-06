package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19598_최소회의실개수 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
	
		int[][] meeting = new int[N][2];
	
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(meeting, (a, b) -> {
			if (a[0] == b[0])
				return a[1] - b[1];
			return a[0] - b[0];
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();

	
		pq.add(meeting[0][1]);
	
		for (int i = 1; i < N; i++) {
			
			if (meeting[i][0] >= pq.peek()) {
				pq.poll();
			}
		
			pq.add(meeting[i][1]);
		}

		
		int result = pq.size();

		
		bw.write(result + "\n");
		bw.flush();

	
		br.close();
		bw.close();
	}

}
