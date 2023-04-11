package chapter7;

public class mission7 {

	public static void main(String[] args) {

		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println("1부터 1000까지 더하면? " + sum);

		// -----------------------------------------//

		int j = 1000;
		int sums = 0;

		sums = j * (j + 1) / 2;
		System.out.println("1부터 1000까지 더하면? " + sums);
		System.out.println();

		// -----------------------------------------//

		int sumOdd = 0;

		for (int k = 1; k <= 1000; k = k + 2) {
			sumOdd += k;
		}
		System.out.println("1부터 1000까지 홀수만 더하면? " + sumOdd);
		System.out.println();

		// -----------------------------------------//

		int sumEven = 0;
		for (int l = 0; l <= 1000; l = l + 2) {
			sumEven += l;
		}

		System.out.println("1부터 1000까지 짝수만 더하면? " + sumEven);
		System.out.println("1부터 1000까지 짝수만 더하면? " + (sum - sumOdd));
		System.out.println();

		// -----------------------------------------//

		int sumEvens = 0;
		int sumOdds = 0;
		
		for (int m = 1; m <= 1000; m++) {

			if (m % 2 == 0) {
				sumEvens += m;
			} else {
				sumOdds += m;
			}
		}
		System.out.println("1부터 1000까지 더하면? "+(sumEvens+sumOdds));
		System.out.println("1부터 1000까지 짝수만 더하면? " + sumEvens);
		System.out.println("1부터 1000까지 홀수만 더하면?" + sumOdds);
		

	}

	// 회전율. for를 최소한으로 돌려서. 메소드로

}
