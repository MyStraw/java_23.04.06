package study;

public class day1 {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		int z = sum(a,b);
	//	int zz = sum((double)a, (double)b);
		
		int p = What();
		
		
		Sayanithing(); ////void 값은 반환이 안돼서 여기서 걍 적어도 된다. return 없이.
		
		System.out.println(z);
		
	
				
				
	}	
	
	public static int sum(int x, int y) { //메인 스태틱. 스태틱 함수만 받는다 생각해. 인스턴스 만들어주지 않았잖아.
	
		return x + y;
	}
	
	
	public static void Sayanithing() {
		System.out.println("아무말");
	}
	
	public static int What() {
		
		int k = 11+2 /3;
		
		return k;
	}
	

}
