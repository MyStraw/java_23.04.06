package chapter9;

class MyObject {
	int num;

	public MyObject(int num) {
			this.num = num;
	}

	public String toString() {
		return "MyObject";
	}

}
public class Test01 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		Class c = obj1.getClass();
		System.out.println(c.getName());
		System.out.println("------------------------------------");

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println("------------------------------------");

		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		System.out.println("------------------------------------");

		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println("------------------------------------");

		MyObject my1 = new MyObject(123);
		MyObject my2 = new MyObject(123);

		if (my1.equals(my2))
			System.out.println("equals::my1 같다 my2");
		else
			System.out.println("다르다");
		System.out.println("------------------------------------");
		// Test01 t = new Test01();
		// MyObject my = t.new MyObject();
		// my.equals(my)

		System.out.println(obj1.equals(obj3));
		System.out.println(obj1.hashCode());
		System.out.println(obj3.hashCode());
		if (obj1 == obj3)
			System.out.println("==::같다");
		else
			System.out.println("==::다르다");
		System.out.println("my = " + my1.hashCode() + "my2 = " + my2.hashCode() );
		System.out.println("------------------------------------");

//		MyObject obj4 = new MyObject(123);
//		System.out.println(obj4);
//
//		MyObject obj5 = new MyObject(123);
//		if (obj4.equals(obj5)) {
//			System.out.println("동일 객체이다.");
//		} else {
//			System.out.println("다른 객체이다.");
//		}
//
//		if (obj4 == obj5) {
//			System.out.println("동일 객체이다.");
//		} else {
//			System.out.println("다른 객체이다.");
//		}
	}
}
