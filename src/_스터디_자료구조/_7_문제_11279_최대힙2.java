package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _7_문제_11279_최대힙2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> arrays = new ArrayList<>();

		int max = 0;
		int maxidx = 0;

		for (int i = 0; i < N; i++) {

			int x = Integer.parseInt(br.readLine());

			if (x == 0 && arrays.size() == 0) {
				bw.write("0" + "\n");
				continue;
			}
			if (x != 0) {
				arrays.add(x);
				maxNum(arrays);
				max = maxx.getMax();
				maxidx = maxx.getMaxIndex();
				continue;
			}
			if (x == 0 && arrays.size() != 0) {
				bw.write(String.valueOf(max) + "\n");
				arrays.remove(maxidx);
				maxNum(arrays);
				max = maxx.getMax();
				maxidx = maxx.getMaxIndex();
				continue;
			}
		}
		bw.flush();
		bw.close();
	}

	public static maxx maxNum(List<Integer> arr) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
				maxIndex = i;
			}
		}
		return new maxx(max, maxIndex);
	}

	public static class maxx {

		static int max;

		static int maxIndex;

		public maxx(int max, int maxIndex) {
			this.max = max;
			this.maxIndex = maxIndex;
		}

		public static int getMax() {
			return max;
		}

		public static int getMaxIndex() {
			return maxIndex;
		}
	}

}
