package chapter7.abstraction;
//abstract 지우고 해봤다가, 바디 지우고 뱄다 해보고 에러뜨고 다 해봐.
//에러 메세지 유의깊게 잘봐.
abstract class Employee { //이게 상속 부모
	String name;
	int salary;

	
	public abstract void calcSalary(); // 앞에 abstract 붙으면 메소드 바디 못가진다.

}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨실팅 특별 수당");
	}
}

class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Managerㄴ 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {
}


public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Manager m = new Manager();

		s.calcSalary();
		c.calcSalary();
		m.calcSalary();
	}
}
