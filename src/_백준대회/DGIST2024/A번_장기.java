package _백준대회.DGIST2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A번_장기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] scores = { 13, 7, 5, 3, 3, 2 }; // 차, 포, 마, 상, 사, 졸
	
		String[] chogi = br.readLine().split(" ");
		int[] chogiPiece = new int[6];
		for (int i = 0; i < 6; i++) {
			chogiPiece[i] = Integer.parseInt(chogi[i]);
		}
	
		String[] eungyuInput = br.readLine().split(" ");
		int[] engyuPiece = new int[6];
		for (int i = 0; i < 6; i++) {
			engyuPiece[i] = Integer.parseInt(eungyuInput[i]);
		}
	
		double chogiScore = 0;
		double eungyuScore = 1.5; 

		for (int i = 0; i < 6; i++) {
			chogiScore += chogiPiece[i] * scores[i];
			eungyuScore += engyuPiece[i] * scores[i];
		}

		if (chogiScore > eungyuScore) {
			System.out.println("cocjr0208");
		} else {
			System.out.println("ekwoo");
		}
	}

}
