package chapter8.polymorphism;



class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Managerㄴ 급여 = 기본급 + 팀 성과 수당");
	}
}