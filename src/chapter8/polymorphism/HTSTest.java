package chapter8.polymorphism;

public class HTSTest {
	public static void calcTax(Employee e) {
		System.out.println("소득세를 게산합니다.");
	}
	
	public static void main (String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		
		calcTax(s);
		calcTax(c);
		calcTax(d);
		
	}

}
