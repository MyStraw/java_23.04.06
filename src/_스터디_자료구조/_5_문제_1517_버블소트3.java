package _스터디_자료구조;

public class _5_문제_1517_버블소트3 {
	public static void main(String[] args) { // 두개를 합치면??? 안되네... 생각이 짧았다
		int[] quick = { 4, 1, 2, 3 };
		int dataSize = quick.length;
		int total = 0;

		for (int i = 0; i < dataSize; i++) {
			int pivot = quick[i];
			int pleft = i;
			int pright = dataSize - 1;

			do {
				while (quick[pleft] < pivot) {
					pleft++;
				}
				while (quick[pright] > pivot) {
					pright--;
				}
				if (pleft < pright) {
					swap(quick, pleft++, pright--);
				}
			} while (pleft <= pright);

			System.out.println("피벗: " + pivot);
			System.out.println("피벗 이하의 그룹");
			for (int j = 0; j < pleft; j++) {
				System.out.print(quick[j] + " ");
				total++;
			}
			System.out.println();
			System.out.println("-------------------------");
		}
		System.out.println("총 " + total);
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
