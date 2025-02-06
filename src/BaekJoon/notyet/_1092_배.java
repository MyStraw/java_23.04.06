package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _1092_배 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력 받기
		int n = sc.nextInt();
		Integer[] cranes = new Integer[n];
		for (int i = 0; i < n; i++) {
			cranes[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		Integer[] boxes = new Integer[m];
		for (int i = 0; i < m; i++) {
			boxes[i] = sc.nextInt();
		}

		// 내림차순 정렬
		Arrays.sort(cranes, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());

		// 불가능한 경우 체크
		if (boxes[0] > cranes[0]) {
			System.out.println(-1);
			return;
		}

		// 그리디 알고리즘을 사용하여 최소 시간 계산
		int time = 0;
		while (boxes.length > 0) {
			int index = 0;
			for (int i = 0; i < cranes.length;) {
				if (index == boxes.length)
					break;
				if (cranes[i] >= boxes[index]) {
					// 크레인이 박스를 들 수 있는 경우
					boxes = removeElement(boxes, index);
					i++;
				} else {
					// 크레인이 박스를 들 수 없는 경우
					index++;
				}
			}
			time++;
		}

		System.out.println(time);
	}

	// 배열에서 특정 요소를 제거하는 메소드
	private static Integer[] removeElement(Integer[] array, int index) {
		if (array == null || index < 0 || index >= array.length) {
			return array;
		}
		Integer[] newArray = new Integer[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (i == index) {
				continue;
			}
			newArray[k++] = array[i];
		}
		return newArray;
	}

}
