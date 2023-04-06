package chapter2;

public class Test3 {

	public static void main(String[] args) {//main + ctrl + spacebar
		// TODO Auto-generated method stub
		byte age;
		short point;
		int price;
		long totalSales;
		
		age = 127; //128은 에러.
		point = 128;
		price = 2147483647;
		totalSales = 2147483648L;
		
		System.out.println(age);
		System.out.println(point);
		System.out.println(price);
		System.out.println("totalPrice =" + totalSales);
		
		

	}

}
