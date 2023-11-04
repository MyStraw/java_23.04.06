package _스터디_자료구조;

public class _4_3_단순삽입정렬 {

	static void insertionSort(int[] insert, int dataSize) {
		for (int i = 0; i < dataSize; i++) {
			int j;
			int temp = insert[i];
			for (j = i; j > 0 && insert[j - 1] > temp; j--) {
				insert[j] = insert[j - 1]; //복사 =>즉 이걸 이동으로 치네. 복사연산이 들어간다.
			}
			insert[j] = temp;
		}
	}
}
