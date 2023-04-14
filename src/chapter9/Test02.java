package chapter9;

public class Test02 {
	
	public static void main(String[] args) {
		
		String s1 = new String("hello");
		String s2 = "hello"; //값은 같은데 객체의 
		System.out.println(System.identityHashCode(s1) + "::" + System.identityHashCode(s2));//식별자가다르다
		System.out.println(s1.toString() + "::" + s2.toString());
		System.out.println(s1.hashCode() + "::" + s2.hashCode());
		if(s1==s2)
			System.out.println("s1 == s2");
		else
			System.out.println("같지 않다");
		
		String s3 = new String("java");
		String s4 = "java";
		
		if(s1 ==s3) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		if(s2 == s4) {
			System.out.println("동일 객체이다.");
		}
	}

}
