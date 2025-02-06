package BaekJoon.notyet;

import java.util.Scanner;

public class _27919_UDPC파티 { //이렇게 단순히 숫자세기가 아니다.
	//CCCCCCCCCCCCCCCCCDP를 입력시 답은 UDP가 나온다
	//U도 될수있고 D도 될수있고 P도 될수있기 때문이다
	//이걸 염두에 계속 둬야한다
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String V = sc.next();

		int uCount = 0;
		int dCount = 0;
		int pCount = 0;

		for (int i = 0; i < V.length(); i++) {
			if (V.charAt(i) == 'U' || V.charAt(i) == 'C') {
				uCount++;
			}
			if (V.charAt(i) == 'D' || V.charAt(i) == 'P') {
				dCount++;
				pCount++;
			}
		}
		StringBuilder result = new StringBuilder();

		if (uCount > dCount && uCount > pCount) {
			result.append('U');
		}
		if (dCount > uCount && dCount > pCount) {
			result.append('D');
		}
		if (pCount > uCount && pCount > dCount) {
			result.append('P');
		}

		if (uCount == dCount && uCount > pCount) {
			result.append('U').append('D');
		}
		if (uCount == pCount && uCount > dCount) {
			result.append('U').append('P');
		}
		if (dCount == pCount && dCount > uCount) {
			result.append('D').append('P');
		}
		if (uCount == dCount && dCount == pCount) {
			result.append('U').append('D').append('P');
		}

		if (result.length() == 0) {
			result.append('C');
		}

		System.out.println(result.toString());
	}
}
