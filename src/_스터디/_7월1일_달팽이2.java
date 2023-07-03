package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _7월1일_달팽이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//8퀸?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		int N = Integer.parseInt(br.readLine());
		int NN = N;
		int ja = Integer.parseInt(br.readLine());
		int jax = 0;
		int jay = 0;

		int gaesu = N * N;

		int panic[][] = new int[N][N];		

		for (int i = 0; i < NN / 2; i++) {
			for (int j = 0; j < N; j++) {
				panic[j + i][i] = gaesu;
				gaesu--;
				if (panic[j + i][i] == ja) {
					jax = j + i;
					jay = i;
				}
			}

			for (int k = 1; k < N; k++) {
				panic[NN - 1 - i][k + i] = gaesu;
				gaesu--;
				if (panic[NN - 1 - i][k + i] == ja) {
					jax = NN - 1 - i;
					jay = k + i;
				}
			}

			for (int l = 1; l < N; l++) {
				panic[NN - 1 - l - i][NN - 1 - i] = gaesu;
				gaesu--;
				if (panic[NN - 1 - l - i][NN - 1 - i]== ja) {
					jax = NN - 1 - l - i;
					jay = NN - 1 - i;
				}
			}

			for (int m = 1; m < N - 1; m++) {
				panic[i][NN - 1 - m - i] = gaesu;
				gaesu--;
				if (panic[i][NN - 1 - m - i] == ja) {
					jax = i;
					jay = NN - 1 - m - i;
				}
			}

			N = N - 2;

			if (gaesu == 1) {
				panic[NN / 2][NN / 2] = gaesu;
				if (panic[NN / 2][NN / 2] == ja) {
					jax = NN / 2;
					jay = NN / 2;
				}
			}
		}

		for (int i = 0; i < NN; i++) {
			for (int j = 0; j < NN; j++) {
				bw.write(panic[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.write((jax+1) + " " + (jay+1));
		bw.flush();
		bw.close();

	}
}
