package chapter2;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float exchangeRate = 1136.50f; //F 안치면 에러난다 : cannot convert from double to float : 1136.50을 double로 인식한다. F를 안써주면(소문자도 가능)
		double USDAmount = 600.50;
		double KRWAmount = 682468.25;
		
		System.out.println(exchangeRate);
		System.out.println(USDAmount);
		System.out.println(KRWAmount);
		
		

	}

}
