package Chap2_기본자료구조;
//1. 난수생성

//2. 정렬

import java.util.Random;

public class _03스트링배열정렬 {

	static void showData(String[] items) {
		// 난수생성하여 배열에 입력
		for (String i : items)
			System.out.print("[" + i + "]" + " ");

	}

	static void sortData(String[] items) {
		for (int i = 0; i < items.length -1 ; i++)
			for (int j = i+1; j < items.length; j++) // 스트링정렬로.
				if (items[i].compareTo(items[j]) > 0) // 스트링 혹은 숫자. A - B시에 A가 클경우 1, 같으면 0, A가 작으면 음수가 되겠네
					swap(items, i, j); // 스트링은 아스키코드? 알파벳 순서상에서 A보다 B 값이 클거아냐. 그럼 A-B는 음수다.
	}

	static void swap(String[] items, int i, int j) { // 정렬 메소드 만들기
		String temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "melon", "babo", "cibul" };
		showData(data);
		sortData(data);
		System.out.println("\n정렬후 결과");
		showData(data);
	}
}
