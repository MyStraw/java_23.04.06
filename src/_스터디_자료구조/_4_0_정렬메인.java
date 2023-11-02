package _스터디_자료구조;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static _스터디_자료구조._4_1_버블정렬.bubbleSort1;
import static _스터디_자료구조._4_1_버블정렬.bubbleSort2;
import static _스터디_자료구조._4_1_버블정렬.bubbleSort3;
import static _스터디_자료구조._4_2_단순선택정렬.selectionSort;
import static _스터디_자료구조._4_3_단순삽입정렬.insertionSort;
import static _스터디_자료구조._4_4_셸정렬.shellSort1;
import static _스터디_자료구조._4_4_셸정렬.shellSort2;

public class _4_0_정렬메인 {
	public static boolean upOrdown = true; // true : 오름차순, false : 내림차순
	public static final int num = 7;
	public static int count = 0;
	
	public static void main(String[] args) {
		Random rd = new Random();
		Set<Integer> noDuplicate = new HashSet<>();
		System.out.println("-버블정렬- [버전1]" + "\n");
		int dataSize = num;
		int[] bubble = new int[dataSize];

		long startTime = System.currentTimeMillis();
		long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		for (int i = 0; i < dataSize;) { // 여기서 i++를 하지 않는다.
			int randomNum = rd.nextInt(num) + 1;
			if (noDuplicate.add(randomNum)) {
				bubble[i] = randomNum;
				System.out.print("bubble[" + i + "]: ");
				System.out.println(bubble[i]);
				i++;
			}
		}

		bubbleSort1(bubble, dataSize);
		if (upOrdown)
			System.out.println("\n" + "오름차순으로 정렬 해봄" + "\n");
		else if (!upOrdown)
			System.out.println("\n" + "내림차순으로 정렬 해봄" + "\n");

		for (int i = 0; i < dataSize; i++) {
			System.out.print("bubble[" + i + "]: ");
			System.out.println(bubble[i]);
		}

		long endTime = System.currentTimeMillis();
		long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println();
		System.out.println("실행시간 : " + (endTime - startTime) + " ms");
		System.out.println("메모리 사용량 : " + (endMemory - startMemory) / 1024.0 + " KB");
		System.out.println("교환회수 : " + count);
	}

}
