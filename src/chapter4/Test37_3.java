package chapter4;

//교수님 버전
public class Test37_3 {

	public static void main(String[] args) {
		int[] score = { 90, 85, 78, 100, 98 };

		double avg = 0.0;
		int sum = score[0];
		int max = score[0];
		int min = score[0];

		for (int i = 1; i < score.length; i++) { // i=1인게 위에서 sum에서 score[0] =90을 미리
			//계산했기 때문에 i=0을 이미 위에서 한 셈이다. 언급하면서 i=0을 동시에
			sum += score[i];
			if (max < score[i])
				max = score[i];
			if (min > score[i])
				min = score[i];
		}

		avg = (double) sum / score.length;
		System.out.println("총점: " + sum);
		System.out.println("평균: " + String.format("%.2f", avg));
		System.out.println("최대: " + max);
		System.out.println("최소: " + min);
	}

}
