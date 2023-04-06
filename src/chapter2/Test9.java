package chapter2;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 2;
		boolean gender = false;
		System.out.println(a == 10 && gender == false);
		System.out.println(a == 10 & gender == false); // & 한개는 false라도 끝까지 수행한다는데 뭔말이래
		if (a == 10 & !gender) { //gender == false => 1gender
			a++;
			System.out.println();
		}
		
		if (b > 10 || a < 20) {
			
		}
		
		a += b;
		System.out.println(a);
		a -= b;
		System.out.println(a);
		a *= b;
		System.out.println(a);
		

	}

}
