package _코테준비_소수점_표시법;

public class 소수표시 {
	public static void main(String args[]) {
		double result = 1234.567;
		float total = 1234.567f;
		
		System.out.printf("소수없애기: " + "%.0f\n", result);
		System.out.printf("소수없애기: " + "%.0f\n", total);
		
		System.out.printf("소수점 2째 자리까지 표시: %.2f\n", result);
		System.out.printf("소수점 2째 자리까지 표시: %.2f\n", total);
		
		//둘다 자동 반올림이다.
		//그럼 그냥 버림을 하고싶다면?
		
		result = Math.floor(result * 100) / 100;
		System.out.printf("소수점 2째 자리에서 버림: %.2f\n", result);
		
		//Math.floor은 버림처리. 곱해서 다시 나눈다.
		
	}
}
