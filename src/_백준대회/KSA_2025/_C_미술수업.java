package _백준대회.KSA_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class _C_미술수업 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<Long> bSet = new HashSet<>();
		Set<Long> cSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Long.parseLong(st.nextToken());
			long Y = Long.parseLong(st.nextToken());

			bSet.add(Y - X);
			cSet.add(X + Y);
		}
		List<Long> bList = new ArrayList<>(bSet);
		List<Long> cList = new ArrayList<>(cSet);
		Collections.sort(bList);
		Collections.sort(cList);

		long cBae[] = new long[cList.size()];
		for (int i = 0; i < cList.size(); i++) {
			cBae[i] = cList.get(i);
		}

		long kyojumCount = 0;
		for (long b : bList) {
			long target = -b + 1;
			int index = Arrays.binarySearch(cBae, target);
			if (index < 0) {
				index = -(index + 1);
			}
			kyojumCount += (cBae.length - index);
		}
		System.out.println(kyojumCount);

	}

}
