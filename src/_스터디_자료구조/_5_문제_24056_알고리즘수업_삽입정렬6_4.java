package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_24056_알고리즘수업_삽입정렬6_4 {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] A = new int[dataSize];
		int[] B = new int[dataSize];
		StringTokenizer aToken = new StringTokenizer(br.readLine());
		StringTokenizer bToken = new StringTokenizer(br.readLine());

		for (int i = 0; i < dataSize; i++) {
			A[i] = Integer.parseInt(aToken.nextToken());
			B[i] = Integer.parseInt(bToken.nextToken());

		}
	
		bw.flush();
		bw.close();

		
	}
}
