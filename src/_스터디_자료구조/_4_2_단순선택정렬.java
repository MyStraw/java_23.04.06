package _스터디_자료구조;

import static _스터디_자료구조._4_0_swap.swap;;

public class _4_2_단순선택정렬 {

	static void selectionSort(int[] select, int dataSize) {
		for (int i = 0; i < dataSize - 1; i++) {
			int min = i;
			for (int j = i + 1; j < dataSize; j++) {
				if (select[j] < select[min]) {
					min = j;
				}
			}
			swap(select, i, min);
		}
	}
}
