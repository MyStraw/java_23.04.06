package BaekJoon;

import java.util.Scanner;

public class _30087_진흥원세미나 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String semina = sc.next();
			if (semina.equals("Algorithm"))
				System.out.println(204);
			else if (semina.equals("DataAnalysis"))
				System.out.println(207);
			else if (semina.equals("ArtificialIntelligence"))
				System.out.println(302);
			else if (semina.equals("CyberSecurity"))
				System.out.println("B101");
			else if (semina.equals("Network"))
				System.out.println(303);
			else if (semina.equals("Startup"))
				System.out.println(501);
			else if (semina.equals("TestStrategy"))
				System.out.println(105);
		

		}
	}
}