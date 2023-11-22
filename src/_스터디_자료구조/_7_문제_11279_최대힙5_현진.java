package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _7_문제_11279_최대힙5_현진 {
	private static int[] heap;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		heap = new int[n + 1];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				bw.write(getMax() + "\n");
			} else {
				insert(num);
			}
		}
		bw.flush();
	}

	private static void insert(int num) {
		if (count++ == 0) {
			heap[count] = num;
			return;
		}
		int insertIndex = count;
		heap[insertIndex] = num;
		while (insertIndex > 1) {
			if (num < heap[insertIndex / 2])
				break;
			heap[insertIndex] = heap[insertIndex / 2];
			insertIndex /= 2;
		}
		heap[insertIndex] = num;
	}

	private static int getMax() {
		if (count == 0)
			return 0;
		int root = heap[1];
		int last = heap[count--];
		int lastIndex = 1;
		int next = lastIndex * 2;
		while (next <= count) {
			if (next < count && heap[next] < heap[next + 1])
				next++;
			if (last > heap[next])
				break;
			heap[lastIndex] = heap[next];
			lastIndex = next;
			next *= 2;
		}
		heap[lastIndex] = last;
		return root;
	}
}
