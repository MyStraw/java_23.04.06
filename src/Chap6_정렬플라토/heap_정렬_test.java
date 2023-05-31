package Chap6_정렬플라토;

import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x); // 인터페이스

	public int DeleteMax(int x);
}

class Heap implements MaxHeap {
	final int heapSize = 1000; //냐.10->1000

	public Heap(int sz) { // 생성자
		this.MaxSize=sz; //냐.추가	
		n = 0; //냐. 추가
		heap = new int[MaxSize+1]; //냐. 추가
	}

	public void display() {			
		for (int i = 1; i <= n; i++)
			System.out.print("  (" + i + ", " + heap[i]+ ") ");
		System.out.println();	
	}

	@Override // c 코드 참고
	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i >= 1;) {
			if (i == 1)
				break; // at root
			if (x <= heap[i / 2])
				break;// 자바에서 generic array 사용 안됨
			// move from parent to i
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = x;
	}

	@Override
	public int DeleteMax(int x) {

		int i, j;
		if (n == 0) {
			HeapEmpty();

			return -1;
		}
		x = heap[1];
		int k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if (heap[j] < heap[j + 1])
					j++;
			// j points to the larger child
			if (k >= heap[j])
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;
	}

	private int[] heap;
	private int n; // current size of MaxHeap //현재 최대 크기.
	private int MaxSize; // Maximum allowable size of MaxHeap

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class heap_정렬_test {

	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 20;
		int[] x = new int[count + 1];
		int[] sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				for (int i = 0; i < count; i++) {
					x[i] = (int) (Math.random() * 130);
					heap.Insert(x[i]);
				}
				break;
			case 2: // 배열출력
				heap.display();
				break;
			case 3: // 루프 돌려서 정렬
				for (int i = 1; i <= count; i++)
					sorted[i - 1] = heap.DeleteMax(x[i]); //냐. 추가. 맞나 봐봐
				for (int num : sorted)
					System.out.print(" " + num);
				System.out.println();
				break;

			case 4:
				return;
			}
		} while (select < 5);
		return;
	}
}
