package _스터디_자료구조;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_1517_버블소트 {
	
	static int count = 0;
	static int bubbleSort(int[] bubble, int dataSize) {
		int k = 0;
		while (true) {
			int exchange = 0;
			int last = dataSize - 1;
			for (int j = dataSize - 1; j > k; j--) { // 젤 오른쪽부터
				if (bubble[j] < bubble[j - 1]) { // 오름차순
					swap(bubble, j - 1, j);
					count++;
					exchange++;
					last = j;
				}
			}
			if (exchange == 0)
				break;
			k = last;
		}
		return count;
	}
	
	static void swap(int[] bubble, int index1, int index2) {
		int temp = bubble[index1];
		bubble[index1] = bubble[index2];
		bubble[index2] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] bubble = new int[dataSize];
		StringTokenizer data = new StringTokenizer(br.readLine());

		for (int i = 0; i < dataSize;) {
			bubble[i] = Integer.parseInt(data.nextToken());
			i++;
		}

		bubbleSort(bubble, dataSize);		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();		
	}
	
	

}
