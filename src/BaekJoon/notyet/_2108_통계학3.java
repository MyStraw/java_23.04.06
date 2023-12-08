package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _2108_통계학3 {
	//셋으로 중복제거하고 클래스를 만들어서 거기서 카운트를 올려준다
	//하지만 2중 반복문 때문에 시간초과가 생김
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int tong[] = new int[N];

		int total = 0;
		List<CountTong> countList = new LinkedList<>();

		Set<Integer> samesame = new HashSet<>();

		for (int i = 0; i < N; i++) {
			tong[i] = Integer.parseInt(br.readLine());
			total += tong[i];

			if (samesame.contains(tong[i])) {
				for (CountTong ct : countList) {
					if (ct.getData() == tong[i]) {
						ct.setCount(ct.getCount() + 1);
						break;
					}
				}

			} else
				samesame.add(tong[i]);
			CountTong CT = new CountTong(tong[i]);
			countList.add(CT);
		}

		Collections.sort(countList, new Comparator<CountTong>() {
			@Override
			public int compare(CountTong o1, CountTong o2) {
				int getMax = Integer.compare(o1.getCount(), o2.getCount());
				if (getMax == 0) {
					return Integer.compare(o1.getData(), o2.getData());
				}
				return getMax;
			}
		});

		int sameCount = 0;
		for (int i = 0; i < countList.size(); i++) {
			if (countList.get(i).getCount() == countList.get(countList.size() - 1).getCount()) {
				sameCount++;
			}
		}

		double sansul = (double) total / N;

		bw.write(String.valueOf(Math.round(sansul) + "\n"));
		// System.out.println(Math.round(sansul));
		Arrays.sort(tong);
		bw.write(String.valueOf(tong[N / 2] + "\n"));
		// System.out.println(tong[N / 2]);

//		for (int i = 0; i < N; i++) {
//			System.out.println(countList.get(i));
//		}

		if (sameCount >= 2) {
			bw.write(String.valueOf(countList.get(countList.size() - sameCount + 1) + "\n"));
			// System.out.println(countList.get(countList.size() - sameCount + 1));
		} else
			bw.write(String.valueOf(countList.get(countList.size() - 1) + "\n"));
		// System.out.println(countList.get(countList.size() - 1));
		bw.write(tong[N - 1] - tong[0] + "\n");
		// System.out.println(tong[N - 1] - tong[0]);

		bw.flush();
		bw.close();
	}

	public static class CountTong {
		private int data;
		private int count;

		public CountTong() {
		}

		public CountTong(int data) {
			this.data = data;
			count++;
		}

		public int getCount() {
			return count;
		}

		public int getData() {
			return data;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return String.valueOf(data);
		}

//		@Override
//		public String toString() {
//			return String.valueOf(data);
//		}

	}

}
