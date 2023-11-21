package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _7_문제_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> arrays = new ArrayList<>();

		int min = 2147483647;
		int minidx = 0;

		for (int i = 0; i < N; i++) {

			int x = Integer.parseInt(br.readLine());
			if (x == 0 && arrays.size() == 0) {
				bw.write("0" + "\n");
				continue;
			}
			if (x != 0) {
				arrays.add(x);
				minNum(arrays);
				min = minn.getMax();
				minidx = minn.getMaxIndex();
				continue;
			}
			if (x == 0 && arrays.size() != 0) {
				bw.write(String.valueOf(min) + "\n");
				arrays.remove(minidx);
				minNum(arrays);
				min = minn.getMax();
				minidx = minn.getMaxIndex();
				continue;
			}
		}
		bw.flush();
		bw.close();
	}

	public static minn minNum(List<Integer> arr) {
		int min = 2147483647;
		int minIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min) {
				min = arr.get(i);
				minIndex = i;
			}
		}
		return new minn(min, minIndex);
	}

	public static class minn {

		static int min;

		static int minIndex;

		public minn(int min, int minIndex) {
			this.min = min;
			this.minIndex = minIndex;
		}

		public static int getMax() {
			return min;
		}

		public static int getMaxIndex() {
			return minIndex;
		}
	}

}
