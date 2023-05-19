package _스터디;

public class 재귀연습 {
	
	public static int sum1 (int n) {
		if (n ==1) {
			return 1;
		}
		
		else {
			return (n+sum1(n-1));
		}
		
	}
	
	public static int sum2(int n) {
		int sum = 0;
		for (int i = 1; i<=n; i++) {
			sum += i;
		}
		return sum;
		
	}
	
	public static void main(String[] args) {	
		
		
		System.out.println(sum2(5));
	}

}
