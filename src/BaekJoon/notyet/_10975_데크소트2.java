package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class _10975_데크소트2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> arr = new ArrayList<>();
		arr.add(new Pair(-1001, -1001)); 
		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(br.readLine());
			arr.add(new Pair(value, i));
		}
		arr.add(new Pair(1010, 1010)); 

		List<Pair> temp = new ArrayList<>(arr);
		Collections.sort(arr, Comparator.comparingInt(p -> p.value));

		List<Deque<Pair>> deques = new ArrayList<>();
		deques.add(new ArrayDeque<>());
		deques.get(0).add(temp.get(1));

		for (int i = 2; i <= n; i++) {
			boolean added = false;
			for (Deque<Pair> deque : deques) {
				int frontValue = binsh(arr, deque.peekFirst().value);
				int backValue = binsb(arr, deque.peekLast().value);
				if (frontValue == temp.get(i).value) {
					deque.addFirst(temp.get(i));
					added = true;
					break;
				} else if (backValue == temp.get(i).value) {
					deque.addLast(temp.get(i));
					added = true;
					break;
				}
			}
			if (!added) {
				Deque<Pair> newDeque = new ArrayDeque<>();
				newDeque.add(temp.get(i));
				deques.add(newDeque);
			}
		}

		System.out.println(deques.size());
	}

	private static int binsh(List<Pair> arr, int value) {
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i).value == value) {
				return arr.get(i - 1).value;
			}
		}
		return -1; 
	}

	private static int binsb(List<Pair> arr, int value) {
		for (int i = arr.size() - 2; i >= 1; i--) {
			if (arr.get(i).value == value) {
				return arr.get(i + 1).value;
			}
		}
		return -1; 
	}

	static class Pair {
		int value, index;

		Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

}
