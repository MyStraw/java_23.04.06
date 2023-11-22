package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class _7_문제_11279_최대힙2_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> arrays = new ArrayList<>();

		Maxx maxx = null; // maxx 초기화

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0 && arrays.size() == 0) {
				bw.write("0\n");
				continue;
			}
			if (x != 0) {
				arrays.add(x);
				maxx = maxNum(arrays);
				continue;
			}
			if (x == 0 && arrays.size() != 0) {
				if (maxx != null) { // maxx가 null이 아닌 경우에만
					bw.write(String.valueOf(maxx.getMax()) + "\n");
					arrays.remove(maxx.getMaxIndex());
					if (!arrays.isEmpty()) {
						maxx = maxNum(arrays);
					}
				}
				continue;
			}
		}
		bw.flush();
		bw.close();
	}

	public static Maxx maxNum(List<Integer> arr) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > max) {
				max = arr.get(i);
				maxIndex = i;
			}
		}
		return new Maxx(max, maxIndex);
	}

	private static class Maxx {

		int max;

		int maxIndex;

		public Maxx(int max, int maxIndex) {
			this.max = max;
			this.maxIndex = maxIndex;
		}

		public int getMax() {
			return max;
		}

		public int getMaxIndex() {
			return maxIndex;
		}
	}

}
