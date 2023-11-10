package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트4 {
	static int[] buff;
	static long count;

	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0;
			int j = 0;
			int k = left;

			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = a[i];			
			}

			while (i <= right && j < p) {
				if (buff[j] <= a[i]) {
					a[k++] = buff[j++]; 							
				}
				else {
					a[k++] = a[i++];
					count++;
				}
				
			}

			while (j < p) {
				a[k++] = buff[j++];				
			}

		}
	}

	static void mergeSort(int[] a, int n) {
		buff = new int[n];

		__mergeSort(a, 0, n - 1);

		buff = null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dataSize = Integer.parseInt(st.nextToken());
		int[] bubble = new int[dataSize];	
		StringTokenizer data = new StringTokenizer(br.readLine());
		for (int i = 0; i < dataSize; i++) {			
			bubble[i] = Integer.parseInt(data.nextToken());
		}
		
		
		mergeSort(bubble, dataSize);		
		
		System.out.println(count);

	}	

}