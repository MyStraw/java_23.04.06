package _스터디_자료구조;

public class _4_4_셸정렬 {

	static void shellSort1(int[] shell, int dataSize) {
		for (int h = dataSize / 2; h > 0; h /= 2) { // h의 초기값, h의 조건, 그리고 밑에 돌고 마지막에 h를 2로 나눈값
			for (int i = h; i < dataSize; i++) {
				int j;
				int temp = shell[i];
				for (j = i - h; j >= 0 && shell[j] > temp; j -= h) { //4번째까지 왔을때야 비로소 [0]과 비교
					shell[j + h] = shell[j];
				}
				shell[j + h] = temp;
			}
		}
	}

	static void shellSort2(int[] shell, int dataSize) {
		int h;
		for (h = 1; h < dataSize; h = h * 3 + 1)
			;
		for (; h > 0; h /= 3) { //h의 초기값을 위해서 정해줌
			for (int i = h; i < dataSize; i++) {
				int j;
				int temp = shell[i];
				for (j = i - h; j >= 0 && shell[j] > temp; j -= h) {
					shell[j + h] = shell[j];
				}
				shell[j + h] = temp;
			}
		}
	}
}
