package chapter14;
//666p~668

@FunctionalInterface //어노테이션. @override 같은.
interface MultiplyTest {
	double getValue();
	//double print();
}
@FunctionalInterface
interface verify {
	boolean check(int n, int d);
	
}

public class TestMultiply {
	public static void main(String[] args) {
		verify v = (n, d) -> (n % 2)== 0;
		System.out.println("v = " + v.check(10, 3));
		MultiplyTest m;
		m = ()->3.14 * 2;
		System.out.println("m = " + m.getValue());
		
		
	}

}
