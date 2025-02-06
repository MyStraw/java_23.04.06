package BaekJoon.notyet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _4375_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 테스트 케이스를 입력받음
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			System.out.println(findSmallestMultiple(n));
		}

		scanner.close();
	}

	// 각 자릿수가 1로만 이루어진 n의 배수를 찾는 메서드
	public static int findSmallestMultiple(int n) {
		// 방문 여부를 저장하는 배열
		boolean[] visited = new boolean[n];

		// BFS 탐색을 위한 큐
		Queue<Node> queue = new LinkedList<>();

		// 초기 값으로 "1"을 큐에 추가
		queue.add(new Node(1 % n, 1));
		visited[1 % n] = true;

		// BFS 탐색 시작
		while (!queue.isEmpty()) {
			Node current = queue.poll();

			// 현재 노드의 값이 0이면 (즉, n의 배수인 경우)
			if (current.value == 0) {
				return current.length;
			}

			// 다음 자릿수로 "1"을 추가한 값과 나머지 연산
			int nextValue = (current.value * 10 + 1) % n;

			// 방문하지 않은 경우에만 큐에 추가
			if (!visited[nextValue]) {
				queue.add(new Node(nextValue, current.length + 1));
				visited[nextValue] = true;
			}
		}

		// 불가능한 경우는 없으므로 이 코드는 절대 도달하지 않음
		return -1;
	}

	// BFS 탐색을 위한 노드 클래스
	static class Node {
		int value; // 현재 값
		int length; // 자릿수 길이

		Node(int value, int length) {
			this.value = value;
			this.length = length;
		}
	}
}
