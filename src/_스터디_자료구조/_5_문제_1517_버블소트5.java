package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트5 {
	static int[] buff;
	static long count;	

	static void __mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int i;
			int center = (left + right) / 2;
			int p = 0; //buff에 복사된 배열 수
			int j = 0; //현재까지 병합된 수
			int k = left; // sort후 a[]에 다시 넣을때

			__mergeSort(a, left, center);
			__mergeSort(a, center + 1, right);

			for (i = left; i <= center; i++) {
				buff[p++] = a[i];
			}
			while (i <= right && j < p) {
				if (buff[j] <= a[i]) {  //정렬이 되어있다면 a배열에 그대로 넣기	
					a[k++] = buff[j++];	 // 정렬이 되어있다면 buff의 것들이 다 소비가 된다.		
				} else {  //정렬이 되어있지 않구나! 그럼 바꿔야지!!					
					a[k++] = a[i++]; //a의 왼쪽에 값을 넣자, 그리고 한칸 오른쪽 이동 (아래 while에서 채움)
					count += (p-j); //buff에 남은 값들이 현재 a배열의 값보다 클때. buff에 남은 수를 카운트.
					//p-j는 즉, 아직 쓰이지 않은 buff다.
				}
			}
			while (j < p) { //buff에 있는걸 a에 빼서 준다고 생각! buff에 남아있단건 역전이 되어있다!!는것.
				a[k++] = buff[j++]; //한칸 오른쪽 이동된 a에 남은값 채우기			
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
