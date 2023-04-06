package chapter2;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		a++;
		System.out.println(a); // 11
		++a;
		System.out.println(a); // 12
		
		int b = 10;
		b--;
		System.out.println(b); // 9
		--b;
		System.out.println(b); // 8
		
		int c = 10;
		int d = 10;
		System.out.println(++c); // 11
		System.out.println(d++); // 10
		
		System.out.println("----------------");
		int n =10;
		System.out.println("n++ = " + n++); //print에서 확인이 되는데 n++ 하면 n을 먼저 print 하고 증/감 (+1) 한다
		System.out.println("++n = " + ++n); //일단 증감/ (+1)을 먼저 하고 그다음 증감된 n을 출력한다
		n++;
		++n;
		System.out.println("n = " + n);
		
		//n++ = 20; error : the left side of an assignment must be a variable(변수) 왼쪽이 변수가 아니다, lvalue가 아니다. n = 10 에서 n은 변수, 10은 값.
		//++n = 30;
	

	}

}
