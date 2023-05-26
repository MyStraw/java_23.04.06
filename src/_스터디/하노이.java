package _스터디;

public class 하노이 {
	public static void main(String[] args) {
		Hanoi(3, 'A', 'B', 'C');

	}

	public static void Hanoi(int Num, char from, char by, char to) {
		if (Num == 1)
			System.out.println(Num + "이동" + from + "->" + to);
		else {
			Hanoi(Num - 1, from, to, by);
			System.out.println(Num + "이동" + from + "->" + to);
			Hanoi(Num - 1, by, from, to);
		}
	}
}
