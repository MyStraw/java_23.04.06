package chapter14;


//
//interface StringFunc {
//	String modify(String s);
//}
//
//interface IntegerFunc {
//	Integer modify(Integer s);
//}

interface Myfunc<T>{
	T modify(T t);
}
public class Test06 {
	public static void main(String[] args) {
		MyFunc<Integer> mf2 =(n) -> n*2;
		MyFunc<String> mf1 = (s) -> s.toUpperCase() + s.length();
		
		int n = 10;
		Integer object1 = 10;
	}

}
