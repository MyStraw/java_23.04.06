package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트7 {
	static Deque<Integer> buff;
	static long count;

	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;

			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);

			buff.clear();
			for (int i = left; i <= center; i++) {
				buff.addLast(a[i]);
			}

			int i = center + 1;
			int k = left;
			while (!buff.isEmpty() && i <= right) {
				if (buff.peekFirst() <= a[i]) {
					a[k++] = buff.pollFirst();
				} else {
					count += buff.size();
					a[k++] = a[i++];
				}
			}

			while (!buff.isEmpty()) {
				a[k++] = buff.pollFirst();
			}
		}
	}

	static void mergeSort(int[] a, int n) {
		buff = new LinkedList<>();
		__mergeSort(a, 0, n - 1);
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
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
