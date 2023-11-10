package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트6 {
	static int[] buff;
	static long count;

	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i; // buff로 복사할때
			int center = (left + right) / 2;
			int buff_size = 0; //buff에 복사된 배열 수
			int buff_merge = 0; //현재까지 병합된 수
			int sort_a = left; // sort후 a[]에 다시 넣을때

			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[buff_size++] = a[i];
			}
			while (i <= right && buff_merge < buff_size) {
				if (buff[buff_merge] <= a[i]) {
					a[sort_a++] = buff[buff_merge++];
				} else {					
					a[sort_a++] = a[i++];
					count += (buff_size - buff_merge); //buff에 남은 값들이 현재 a배열의 값보다 클때
					
				}
			}
			while (buff_merge < buff_size) {
				a[sort_a++] = buff[buff_merge++];
			}
		}
	}

	static void mergeSort(int[] a, int n) {
		buff = new int[n];
		__mergeSort(a, 0, n - 1);
		buff = null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] bubble = new int[dataSize];
		StringTokenizer data = new StringTokenizer(br.readLine());
		for (int i = 0; i < dataSize; i++) {
			bubble[i] = Integer.parseInt(data.nextToken());
		}
		mergeSort(bubble, dataSize);
		System.out.println(count);
	}
}
