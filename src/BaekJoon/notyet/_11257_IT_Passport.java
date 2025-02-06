package BaekJoon.notyet;

import java.util.Scanner;

public class _11257_IT_Passport {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
	
		for (int i = 0; i < N; i++) {
		
			int candidateId = sc.nextInt();
			int strategyScore = sc.nextInt();
			int managementScore = sc.nextInt();
			int technologyScore = sc.nextInt();
		
			double strategyMin = 35 * 0.3;
			double managementMin = 25 * 0.3;
			double technologyMin = 40 * 0.3;
	
			int totalScore = strategyScore + managementScore + technologyScore;

			boolean isPass = totalScore >= 55 && strategyScore >= strategyMin && managementScore >= managementMin
					&& technologyScore >= technologyMin;
		
			if (isPass) {
				System.out.println(candidateId + " " + totalScore + " PASS");
			} else {
				System.out.println(candidateId + " " + totalScore + " FAIL");
			}
		}

	}

}
