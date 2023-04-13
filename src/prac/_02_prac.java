package prac;

public class _02_prac {

	public static void main(String[] args) {
		int sumEvens = 0;
		int sumOdds = 0;

		for (int m = 1; m <= 1000; m++) {

			if (m % 2 == 0) {
				sumEvens += m;
			} else {
				sumOdds += m;
			}
		}
		System.out.println("1부터 1000까지 더하면? " + (sumEvens + sumOdds));
		System.out.println("1부터 1000까지 짝수만 더하면? " + sumEvens);
		System.out.println("1부터 1000까지 홀수만 더하면? " + sumOdds);
	}

}
