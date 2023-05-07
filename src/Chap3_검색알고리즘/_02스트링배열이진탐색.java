package Chap3_검색알고리즘;

import java.util.Scanner;

public class _02스트링배열이진탐색 {

	static void showData(String[] items) {
		// 난수생성하여 배열에 입력
		for (String i : items)
			System.out.print("[" + i + "]" + " ");

	}

	static void sortData(String[] items) {
		for (int i = 0; i < items.length - 1; i++)
			for (int j = i + 1; j < items.length; j++)
				if (items[i].compareTo(items[j]) > 0)
					swap(items, i, j);
	}

	static void swap(String[] items, int i, int j) { // 정렬 메소드 만들기
		String temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public static void main(String[] args) {
		String[] data = { "grape", "apple", "melon", "banana", "carrot", "xylitol", "honeydew" };
		showData(data);
		sortData(data);
		System.out.println("\n정렬후 결과");
		showData(data);
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("index 찾으려는 key값 입력");
		String key = sc.next();
		int result = binSearch(data, key);

		System.out.println();
		if (result != -1) {
			System.out.println("원하는 값 " + key + "는(은) 인덱스 " + result + "(" + (result + 1) + "번째)" + "에 있습니다.");
		} else {
			System.out.println("원하는 값 " + key + "를(을) 찾지 못했습니다.");
		}

	}

	private static int binSearch(String[] data, String key) {
		int left = 0;
		int right = data.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (data[mid].compareTo(key) == 0) { //그냥== 쓰면 그냥 동일객체를 참조하는지 확인. 내용까지 확인은 안됨.
				return mid;
			} else if (data[mid].compareTo(key) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}

}
