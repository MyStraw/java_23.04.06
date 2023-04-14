package chapter8.inner;

public class 객체배열외부클래스 { // 객체배열에선 밖에 있었는데 이번엔 내부로 들어온다.

	class Student { // 이 내부의 클래스 사용하려면 객체가 있어야 사용할수 있징
		int sid;
		String sname;

		Student(int sid, String sname) {
			this.sid = sid;
			this.sname = sname;

		}

		public String toString() {// 필드값을 아래 형식으로 리턴 //public 안쓰면 왜 에러나는지?
			return "sid = " + sid + ", sname = " + sname;
		}
		void show() {
			System.out.println(this.toString());
			//System.out.println("sid = " + sid + ", sname = " + sname); 앞으로 이렇게 사용 안할겨. 투스트링만.
		}
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		Student[] sdata = new Student[10]; // heap 영역에 공간 10개 할당. 연속된 공간.
		data[0] = 10;
		객체배열외부클래스 my = new 객체배열외부클래스(); // 객체만듦. 객체.new
		sdata[0] = my.new Student(2023, "hong"); // 2023, hong을 준다. 위의 new와 달라
		sdata[1] = my.new Student(2022, "kim");
		sdata[2] = my.new Student(2021, "lee");
		sdata[3] = my.new Student(2020, "park");
		sdata[4] = my.new Student(2019, "choi");
		if(sdata[0]==sdata[1]) {}
		if(sdata[0].equals(sdata[1]) == true) {}
		for (int i = 0; i < 5; i++) {
			sdata[i].show();
			System.out.println("::" + sdata[i].toString());

		}

	}
}
