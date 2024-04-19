package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _25305_커트라인 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int x[] = new int[N];
		Integer xx[] = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
			xx[i] = x[i];
		}

//		Arrays.sort(x, new Comparator<Integer>() { //comparator은 객체타입을 위한 비교만.
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				int com = Integer.compare(o1, o2);
//				return com;
//			}
//		});
		Arrays.sort(x);

		Arrays.sort(xx, Comparator.reverseOrder());

		System.out.println(x[N - k]);
		System.out.println(xx[k-1]);
	}

}
