package chapter14;
interface NumberFunc{
int func(int n);
}
public class Test05 {
	public static void main(String[] args) {
		NumberFunc sum = (n) ->{
			int result = 0;
			for (int i = 0; i <=n; i++) {
				result += 1;
			}
			return result; //빠뜨리지 말긔. 인터페이스 int func. 반환
		}; //잊지말긔
		System.out.println("sum = " + sum.func(10));
	}

}
