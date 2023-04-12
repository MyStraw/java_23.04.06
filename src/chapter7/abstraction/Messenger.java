package chapter7.abstraction;

public interface Messenger {

	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 104857600;

	public abstract String getMessage();//

	public abstract void setMessage(String msg); // 무조건 구현하라공. abstract 없어도 된당

	public default void setLogin(boolean login) { //디폴트 메소드는 바디 가질수있다.
		log();
		if (login) {
			System.out.println("로그인 처리합니다.");

		} else {
			System.out.println("로그아웃 처리합니다");
		}
	}

	public static void getConnectio() {//얘는 코드영역에서 활동하니까 바로 사용가능해서 메소드랑 별개로 생각
		System.out.println("network에 연결합니다.");

	}

	private void log() {//얘는 내부라서 사용
		System.out.println("start job!");
	}
}
