package chapter7;

public class CalcSumSub {

	private int total;
	private int oddsum;
	private int evnsum;

	private void CalcSumSub(int sum) {
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0)
				evnsum += 1;
			else
				oddsum += 1;

			total = evnsum + oddsum;

		}
		
		public int getTotal() { return total;}
		public int getOddsum( ) { return oddsum;}
		public int getEvnsum() {return evnsum; }
		

	}

	public class CalcSum{
		
	}
	public static void main(String[] args) {
		
		int arg = Integer.parseInt(args[0]);
		
		CalcSumSub cs = new CalcSumSub(arg);
		
		System.out.println(cs.getTotal());
		System.out.println(cs.getEvnsum());
		System.out.println(cs.getOddsum());
		

	}

}
