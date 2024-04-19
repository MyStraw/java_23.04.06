package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2566_최댓값 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st ;

		int max = 0;
		int x = 0;
		int y = 0;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());	
			for (int j = 0; j < 9 ; j++) {					
				int num = Integer.parseInt(st.nextToken());
				if (num >= max) {
					max = num;
					x = i + 1;
					y = j + 1;
				}
			}
		}
		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(x + " " + y));
		bw.flush();
		bw.close();

	}

}
