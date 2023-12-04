package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2751_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(br.readLine()) ;
		int[] su = new int[N];

		for (int i = 0; i < N; i++) {
			su[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (su[j] > su[j + 1]) {
					swap(su, j, j + 1);
				}

			}

		}

		for (int r : su) {
			bw.write(Integer.toString(r)+ "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void swap(int[] su, int i, int j) {
		int temp = su[i];
		su[i] = su[j];
		su[j] = temp;
	}

}


//ArrayList<Integer> suu = new ArrayList<>();
//
//for (int i = 0; i < N; i++) {
//	suu.add(i, Integer.parseInt(br.readLine()));
//}

