package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _32686_DPS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] R = new int[N];
		int[] A = new int[N];
		long[] D = new long[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			A[i] = Integer.parseInt(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}

		double totalDamage = 0;

		for (int i = 0; i < N; i++) {
			int cycleTimeE = R[i] + A[i];
			long fullCyclesE = E / cycleTimeE;
			double remainingTimeE = E % cycleTimeE;

			double damageE = fullCyclesE * D[i];
			if (remainingTimeE > R[i]) {
				double partialCastTimeE = Math.min(remainingTimeE - R[i], A[i]);
				damageE += (partialCastTimeE / A[i]) * D[i];
			}

			int cycleTimeS = R[i] + A[i];
			long fullCyclesS = S / cycleTimeS;
			double remainingTimeS = S % cycleTimeS;

			double damageS = fullCyclesS * D[i];
			if (remainingTimeS > R[i]) {
				double partialCastTimeS = Math.min(remainingTimeS - R[i], A[i]);
				damageS += (partialCastTimeS / A[i]) * D[i];
			}

			totalDamage += damageE - damageS;
		}

		System.out.println(totalDamage / (E - S));
	}

}
