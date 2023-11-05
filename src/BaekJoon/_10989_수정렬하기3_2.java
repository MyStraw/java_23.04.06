package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10989_수정렬하기3_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] shell = new int[N];

		for (int i = 0; i < N; i++) {
			shell[i] = Integer.parseInt(br.readLine());
		}

		for (int h = N / 2; h > 0; h /= 2) { // h의 초기값, h의 조건, 그리고 밑에 돌고 마지막에 h를 2로 나눈값
			for (int i = h; i < N; i++) {
				int j;
				int temp = shell[i];
				for (j = i - h; j >= 0 && shell[j] > temp; j -= h) { //4번째까지 왔을때야 비로소 [0]과 비교
					shell[j + h] = shell[j];
				}
				shell[j + h] = temp;
			}
		}

		for (int r : shell) {
			bw.write(Integer.toString(r) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
