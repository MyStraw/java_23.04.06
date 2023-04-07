package prac;

class Count {//메인이 없으니까 퍼블릭 달지마. 그럼 파일이름 같지 않아도 돼
	static int totalCount;
	private int count;
	private int num; //1111111111111 //private 넣고 빼고 해봐
	public void setNum(int n) {//2222222222222
		num = n;
	}
	public int getNum() { //겟넘버 정의해놨다
		return num;
	}
}

//퍼블릭은 여기 이 클래스 밑으로 내려가도 쓸수있다
//

public class CountTest {
	int m = 10;
	public void show() {
		System.out.println("hello");
	}
	public static void main(String[] args) { //여기 아래 num, c1, c2, c3, 지역변수. stack 영역, public 지워보고 해봐. num, count 뭐가 막 바뀌는지
		CountTest cx = CounTest();
		cx.show();
		//CounTest.show(); //클래스 메소드. 객체가 없어도 만들어진다
		//show(); //왜 안되지? 위에 show부분 static을 하면 사용이 돼. data 영역에 입력이 돼서 불러오고 가능. 객체가 만들어지지 않아도 사용 가능하지.
		int num = 0;
		CountTest.totalCount = 10; // 퍼블릭, 스태틱. =>데이터 영역에 저장. 
		//Count.num = 20; //위는 되고 이건 왜 안돼? 프라이빗이니까. 위에 봐봐. 스태틱도 아냐. 
		CountTest c1 = new CountTest(); //카운트라는 객체 c1, 카운트 new 해서 c1 변수
		CountTest c2 = new CountTest();
		CountTest c3 = new CountTest();
		CountTest.totalCount = 110;
		c3.totalCount = 110; //힙 가도 객체 없는데 값이 되네? 토탈 카운트 보니 어? 스태틱이네. total로 가면 110이 있다. 그래서 윗줄도 되고 아랫줄도 됨.
		//연습장 봐.
		
		c1.num++; //c1은 new에서 만들어진 객체. 스태틱으로 선언된 필드에서만 가능.

		//c1.count++; //1111111 만 만들면 못읽어온다. 프라이빗 하고 괄호 다 닫혔다
		c1.setNum(num); // 퍼블릭으로 만든건 가져올수 잇다. 22222222222222
		System.out.println("num = " + c1.getNum()); //c1.num 하면 안된다. 그냥 c1.없이 getNum()하면 누군지 모르니. c1은 변수,->카운트,-> 겟넘버로 정의해놨다
		CountTest.totalCount++;
		c2.count++; // 프라이빗이라 안된다.
		CountTest.totalCount++;
		c3.count++;
		CountTest.totalCount++;

		System.out.println(CountTest.totalCount + " : " + c1.count);
		System.out.println(CountTest.totalCount + " : " + c2.count);
		System.out.println(CountTest.totalCount + " : " + c3.count);
	}
}