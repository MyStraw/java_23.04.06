package chapter8;

enum Status {READY, SEND,COMPLETE,CLOSE} //위에꺼 한방에 해결
public class EnumTest01 {
	public static void main(String[] args) {
		//int work = 0;
		Status work = null;
		int n = 2;
		switch(n) {
		case 1:
			work = Status.READY;
			break;
		case 2:
			work = Status.SEND;
			break;
		case 3:
			work = Status.COMPLETE;
			break;
		case 4:
			work = Status.CLOSE;
			break;
		}
		System.out.println("현재 작업 상태 : " + work);
		work.toString(); //. 찍으면 사용 가능한 함수들 나온다. 숙달!
		String name ="hello";
		String sname = "good";
	//	if (name > sname) {} //이거쓰면 에러
		if (name.compareTo(sname)>0) {}
				
	}

}