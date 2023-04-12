package chapter7.abstraction1;

abstract class Employee { // 제한자 없는건 디폴트. 같은 클래스 내에서 접속가능
	private String name;
	private int salary;

	public Employee() { //디폴트 생성자.

	}

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public abstract void calcSalary();

	public abstract void calcBonus();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

//-------------------------------------------------------------------
class Salesman extends Employee {
	
	
	private int sells;

	public Salesman(String name, int salary, int sells) {
		super(name, salary); //상속자
		this.sells = sells;
	}

	
//	public int getSells() {
//		return sells;
//	}

//	public void setSells(int sells) {
//		this.sells=sells;
//	}

	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
		System.out.println(getName() + "의 급여");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");

	}
}

//-------------------------------------------------------------------
class Consultant extends Employee {

	private int consult;

	public Consultant(int consult) {
		this.consult = consult;
	}

	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨실팅 특별 수당");

	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");

	}
}
//-------------------------------------------------------------------

abstract class Manager extends Employee {
	private int team;

	public Manager() {
	
	}
	
	public Manager(int team) {
		this.team = team;
	}

	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}

}

//-------------------------------------------------------------------

class Director extends Manager {

	public Director() {

	}

	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
		// calcSalary를 상속받아.
	}
}

public class HRSTest2 {
	public static void main(String[] args) {

		Salesman s = new Salesman("홍길동", 500, 40);
		Consultant c = new Consultant(30000);
		Manager m = new Director();

		s.calcBonus();
		s.calcBonus();
//		c.calcBonus();
//		m.calcBonus();

	}
}
