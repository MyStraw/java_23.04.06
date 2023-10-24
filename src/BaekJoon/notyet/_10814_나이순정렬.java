package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(br.readLine());
		
		int[][] age = new int[N][N];	
		
		for (int i = 0; i < N; i++) {
			age[i][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (su[j] > su[j + 1]) {
					swap(su, j, j + 1);
				}

			}

		}

		for (int r : su) {
			bw.write(Integer.toString(r) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	class Age {
		int aged;
		String name;
	}
	

	private static void swap(int[] su, int i, int j) {
		int temp = su[i];
		su[i] = su[j];
		su[j] = temp;
	}

}
