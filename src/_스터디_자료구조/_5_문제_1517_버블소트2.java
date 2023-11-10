package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] bubble = new int[dataSize];
		StringTokenizer data = new StringTokenizer(br.readLine());

		for (int i = 0; i < dataSize;) {
			bubble[i] = Integer.parseInt(data.nextToken());
			i++;
		}		
		int count = 0;
		for (int i = 0; i < dataSize; i++) {
			for (int j = i + 1; j < dataSize; j++) {
				if (bubble[i] < bubble[j]) {
					count++;
				}
			}
		}		
		
		bw.write(String.valueOf(count));	
		bw.flush();
		bw.close();		
	}
}
//9
//6 7 5 1 2 4 9 8 3
