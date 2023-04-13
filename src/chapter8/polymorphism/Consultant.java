package chapter8.polymorphism;



class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨실팅 특별 수당");
	}
}