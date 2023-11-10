package _스터디_자료구조;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class _5_문제_24056_알고리즘수업_삽입정렬6 {
	
	public static boolean upOrdown = true; // true : 오름차순, false : 내림차순
	public static final int num = 9;
	public static int count = 0;

	static void insertionSort(int[] insert, int dataSize) {
		for (int i = 0; i < dataSize; i++) { // 맨 왼쪽은 정렬이 끝났다고 가정
			int j;
			int temp = insert[i];
			for (j = i; j > 0 && insert[j - 1] > temp; j--) {
				insert[j] = insert[j - 1]; // 복사 =>즉 이걸 이동으로 치네. 복사연산이 들어간다.
			}
			insert[j] = temp;
		}
	}

	
	public static void main(String[] args) {
		Random rd = new Random();
		Set<Integer> noDuplicate = new HashSet<>();
		System.out.println("-버블정렬- [버전1]" + "\n");
		int dataSize = num;
		int[] bubble = new int[dataSize];	

		for (int i = 0; i < dataSize;) { // 여기서 i++를 하지 않는다.
			int randomNum = rd.nextInt(num) + 1;
			if (noDuplicate.add(randomNum)) {
				bubble[i] = randomNum;
				System.out.print("bubble[" + i + "]: ");
				System.out.println(bubble[i]);
				i++;
			}
		}

		insertionSort(bubble, dataSize);
		if (upOrdown)
			System.out.println("\n" + "오름차순으로 정렬 해봄" + "\n");
		else if (!upOrdown)
			System.out.println("\n" + "내림차순으로 정렬 해봄" + "\n");

		for (int i = 0; i < dataSize; i++) {
			System.out.print("bubble[" + i + "]: ");
			System.out.println(bubble[i]);
		}
	
	}
}

