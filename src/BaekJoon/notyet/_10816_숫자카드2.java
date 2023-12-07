package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _10816_숫자카드2 {
	
	public static Set <cardCount> set1 = new HashSet<>();
	
	public static class cardCount{
		private int cardNum;
		private int count;
		
		public cardCount(int cardNum, int count) {
			this.cardNum = cardNum;
			this.count = count;
		}		
		
		public int getCardNum() {
			return cardNum;
		}

		public int getCount() {
			return count;
		}
		
	}
	
	
	
	public static int hasNum(int cardNum) {
		int count = 0;
		if (set1.contains(cardNum)) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int card[] = new int[N];
		//Set <cardCount> set1 = new HashSet<>(); 
		HashSet <cardCount> set2 = new HashSet<>();		
		
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			set1.add(new cardCount(card[i], hasNum(card[i])));			
		}
		
		
		
		
		Arrays.sort(card);

		int M = Integer.parseInt(br.readLine());
		int check[] = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			int result = binarySearch(card, check[i]);
			System.out.print(result + " ");
		}
		
		
	}



	public static int binarySearch(int[] card, int x) {
		int left = 0;
		int right = card.length - 1;	

		while (left <= right) {
			int mid = (left + right) / 2;			
			if (card[mid] == x) {
				return mid;
			} else if (card[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
