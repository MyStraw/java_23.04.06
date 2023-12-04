package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2751_수정렬하기2_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		

		int N = Integer.parseInt(br.readLine()) ;
		int[] su = new int[N];

		for (int i = 0; i < N; i++) {
			su[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(su);

		for (int r : su) {
			bw.write(Integer.toString(r)+ "\n");
		}
		bw.flush();
		bw.close();
	}	

}


