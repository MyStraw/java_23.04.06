package _스터디_자료구조;

public class _6_1_힙정렬2 {

	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		// 최대힙(루트에 제일 큰 수)
		buildHeap(arr);
		// ----------------------여기까지가 힙 정렬 세팅 O(N)

		int n = arr.length;

		// 하나씩 요소를 꺼내어 정렬을 수행
		for (int i = n - 1; i > 0; i--) {
			// 루트를 배열의 마지막 요소와 교환
			swap(arr, 0, i);

			// 힙의 크기를 줄이고, 힙 속성을 다시 맞춤
			heapify(arr, i, 0);
		}

		// 정렬된 배열 출력
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// 배열을 최대 힙으로 구성하는 메소드
	static void buildHeap(int[] arr) {
		int n = arr.length;

		// 마지막 부모 노드부터 시작하여 루트 노드까지 반복
		for (int i = n / 2 - 1; i >= 0; i--) { // 책에는 (i-1)/2
			heapify(arr, n, i);
		}
	}

	// 힙 상태를 계속 유지
	static void heapify(int[] arr, int n, int i) {
		int largest = i; // 부모 노드
		int left = 2 * i + 1; // 왼쪽 자식 노드
		int right = 2 * i + 2; // 오른쪽 자식 노드

		// 왼쪽 자식이 현재의 'largest'보다 큰 경우
		if (left < n && arr[left] > arr[largest]) { // 인덱스만 바뀌고 데이터 바뀌는게 아냐
			largest = left;
		}

		// 오른쪽 자식이 현재의 'largest'보다 큰 경우
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		// largest가 루트가 아니라면 교환하고, 하위 트리에 대해 heapify를 재귀호출. 2번째가 바뀌었을때 그 하위도 또 해야
		if (largest != i) {
			swap(arr, i, largest);			
			heapify(arr, n, largest);
		}
	}

}
