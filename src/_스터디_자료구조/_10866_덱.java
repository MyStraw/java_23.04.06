package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10866_덱 {
	static int N;
	private static ArrayLinkedList<Integer> intDeque;

	static class ArrayLinkedList<E> {

		class Node<E> {
			private E data;
			private int next;
			private int dnext;

			void set(E data, int next) {
				this.data = data;
				this.next = next;
			}
		}

		private Node<E>[] n;
		private int size;
		private int max;
		private int head;
		private int deleted;
		private int num;
		private static final int NULL = -1;

		@SuppressWarnings("unchecked")
		public ArrayLinkedList(int capacity) {
			head = max = deleted = NULL;
			try {
				n = new Node[capacity];
				for (int i = 0; i < capacity; i++)
					n[i] = new Node<E>();
				size = capacity;
			} catch (OutOfMemoryError e) {
				size = 0;
			}
		}

		private int getInsertIndex() {
			if (deleted == NULL) {
				if (max < size)
					return ++max;
				else
					return NULL;
			} else {
				int rec = deleted;
				deleted = n[rec].dnext;
				return rec;
			}
		}

		private void deleteIndex(int idx) {
			if (deleted == NULL) {
				deleted = idx;
				n[idx].dnext = NULL;
			} else {
				int rec = deleted;
				deleted = idx;
				n[rec].dnext = rec;
			}
		}

		public void addFirst(E obj) {
			int ptr = head;
			int rec = getInsertIndex();
			if (rec != NULL) {
				head = rec;
				n[head].set(obj, ptr);
				num++;////////////////////
			}
		}

		public void addLast(E obj) {
			if (head == NULL)
				addFirst(obj);
			else {
				int ptr = head;
				while (n[ptr].next != NULL)
					ptr = n[ptr].next;
				int rec = getInsertIndex();
				if (rec != NULL) {
					n[ptr].next = rec;
					n[rec].set(obj, NULL);
					num++;////////////////////

				}
			}
		}

		public int removeFirst() {
			if (head == NULL) {
				return -1;
			} else {
				int ptr = n[head].next;
				E data = n[head].data;
				deleteIndex(head);
				head = ptr;
				num--;////////////////////
				return (int) data;
			}
		}

		public int removeLast() {
			if (head == NULL) {
				return -1;
			} else if (n[head].next == NULL) {
				return removeFirst();
			} else {
				int ptr = head;
				int pre = head;

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				E data = n[ptr].data;
				n[pre].next = NULL;
				deleteIndex(pre);
				num--;////////////////////
				return (int) data;
			}
		}
		
		public int size() {
			return num;
		}

		public int empty() {
			if (head == NULL) {
				return 1;
			}
			return 0;
		}

		public int front() {
			if (head != NULL) {
				return (int) n[head].data;
			}
			return -1;
		}

		public int back() {
			if (head == NULL) {
				return -1;
			} else {
				int ptr = head;
				while (n[ptr].next != NULL) {
					ptr = n[ptr].next;
				}
				return (int) n[ptr].data;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		intDeque = new ArrayLinkedList<>(N);

		for (int i = 0; i < N; i++) {
			String order = br.readLine();
			if (order.startsWith("push_front")) {
				String[] command = order.split(" ");
				int num = Integer.parseInt(command[1]);
				intDeque.addFirst(num);
			} else if (order.startsWith("push_back")) {
				String[] command = order.split(" ");
				int num = Integer.parseInt(command[1]);
				intDeque.addLast(num);
			} else if (order.equals("pop_front")) {
				bw.write(intDeque.removeFirst() + "\n");

			} else if (order.equals("pop_back")) {
				bw.write(intDeque.removeLast() + "\n");

			} else if (order.equals("size")) {
				bw.write(intDeque.size() + "\n");

			} else if (order.equals("empty")) {
				bw.write(intDeque.empty() + "\n");

			} else if (order.equals("front")) {
				bw.write(intDeque.front() + "\n");

			} else if (order.equals("back")) {
				bw.write(intDeque.back() + "\n");

			}
		}
		bw.flush();
		bw.close();
	}
}