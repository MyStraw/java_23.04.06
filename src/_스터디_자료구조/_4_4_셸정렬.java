package _스터디_자료구조;

public class _4_4_셸정렬 {

	static void shellSort1(int[] shell, int dataSize) {
		for (int h = dataSize / 2; h > 0; h /= 2) {
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

	static void shellSort2(int[] shell, int dataSize) {
		int h;
		for (h = 1; h < dataSize; h = h * 3 + 1)
			;
		for (; h > 0; h /= 3) {
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
