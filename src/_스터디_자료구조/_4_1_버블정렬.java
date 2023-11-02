package _스터디_자료구조;

import static _스터디_자료구조._4_0_swap.swap;
import static _스터디_자료구조._4_0_정렬메인.*;

public class _4_1_버블정렬 {

	static void bubbleSort1(int[] bubble, int dataSize) {
		for (int i = 0; i < dataSize - 1; i++) {
			for (int j = dataSize - 1; j > i; j--) {
				if (upOrdown) {
					if (bubble[j] < bubble[j - 1]) { // 오름차순
						swap(bubble, i, i);
						count++;
					}

				} else if (!upOrdown) {
					if (bubble[j] > bubble[j - 1]) { // 내림차순
						swap(bubble, j - 1, j);
						count++;
					}
				}
			}
		}
	}

	static void bubbleSort2(int[] bubble, int dataSize) {
		for (int i = 0; i < dataSize - 1; i++) {
			int exchange = 0;
			for (int j = dataSize - 1; j > i; j--) {
				if (bubble[j] < bubble[j - 1]) { // 오름차순
					swap(bubble, j - 1, j);
					count++;
					exchange++;
				}
			}
			if (exchange == 0)
				break;
		}
	}

	static void bubbleSort3(int[] bubble, int dataSize) {
		int k = 0;
		while (k < dataSize - 1) {
			int last = dataSize - 1;
			for (int j = dataSize - 1; j > k; j--) {
				if (bubble[j] < bubble[j - 1]) { // 오름차순
					swap(bubble, j - 1, j);
					count++;
					last = j;
				}
			}
			k = last;
		}
	}
}
