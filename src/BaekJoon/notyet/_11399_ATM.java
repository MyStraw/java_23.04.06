package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] line = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			 line[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(line);

        int total = 0;
        int sum = 0;
        for (int time : line) {
            sum += time; // 각 사람이 기다린 시간 누적
            total += sum; // 전체 기다린 시간 합산
        }

        System.out.println(total);
	}

}
