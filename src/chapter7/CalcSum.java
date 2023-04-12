package chapter7;

class CalcSumSub {

	private int total;
	private int oddsum;
	private int evnsum;
	
	public CalcSumSub(int num) {
		for (int i = 1 ; i <= num ; i++) {
			if (i%2 == 0)	evnsum += i;
			else			oddsum += i;
		}
		total = evnsum + oddsum;
	}
	public int getTotal()  { return total;	}
	public int getOddsum() { return oddsum; }
	public int getEvnsum() { return evnsum; }
}

public class CalcSum {

	public static void main(String[] args) {

		int arg = Integer.parseInt(args[0]); //경로\java\edu\com.java07 100 앞에 바디(경로) 실형명령 제외하고 그 후 첫번째 순서를 0번째라 한다. 여기에 arg값. cmd에서 실행.
		
		CalcSumSub cs = new CalcSumSub(arg);	

		System.out.println("총계 : " + cs.getTotal());
		System.out.println("짝계 : " + cs.getEvnsum());
		System.out.println("홀계 : " + cs.getOddsum());
	}

}
