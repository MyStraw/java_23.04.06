package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _10989_수정렬하기3_3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int N = Integer.parseInt(br.readLine()) ;
		ArrayList<Integer> suu = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			suu.add(i, Integer.parseInt(br.readLine()));
		}


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (suu.get(j) > suu.get(j+1)) {
					swap(suu, j, j + 1);
				}
			}
		}

		for (int r : suu) {
			bw.write(Integer.toString(r)+ "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void swap(ArrayList<Integer> suu, int i, int j) {
		int temp = suu.get(i);		
		suu.set(i, suu.get(j));
		suu.set(j, temp);
	}

}


