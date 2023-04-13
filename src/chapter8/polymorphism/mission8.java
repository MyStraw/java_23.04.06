package chapter8.polymorphism;

// 임의의 수를 입력 받아서 이진수로 변환해서 출력해 봅시다.

// 최대공약수 & 최소공배수
// 두개의 정수를 입력 받아서 최대공약수와 최소공배수를 구해서 출력해봅시다.
// ex) 입력: 12, 18 => 최대공약수:6, 최소공배수:36
// 유클리드 호제법
// 입력받은 두개의 정수 중 큰 정수를 max, 작은 정수를 min
// rem = max%min
// rem = 0이면 -> 최대공약수 = 작은 정수, 최소공배수 = 두 정수의 곱/최대공약수
// rem이 0이 아니면-> max=min, min=rem. 2번반복

// 팩토리얼
// 아래 출력 예와 같은 결과를 얻도록 메소드를 작성해 보세요.
// 출력 예
// 입력 ->4 -> 4!=4*3*2*1 = 24

// 경우의 수
// 2g, 3g, 5g의 추가 각각 10개씩 있을때, 10~100 사이의 임의의 값을 입력 받고,
// 추의 합이 입력 받은 값이 되는 경우를 찾아서 출력하세요.
// 단, 각각의 추는 1개 이상은 사용되어야 합니다.

// 출력 예
// 입력값:31, 
// 출력값( ,) , (, ) 

import java.util.Scanner;

public class mission8 {

	public static void main(String[] args) {

		// 13을 넣으면 2를 나누면 몫은 6, 나머지는 1 -> 1이게 제일 끝
		// 몫인 6을 다시 2로 나누면 몫은 3, 나머지는 0 -> 0
		// 몫인 3을 다시 2로 나누면 몫은 1, 나머지는 1 -> 1
		// 몫 1 (몫이 1보다 작거나 같다) -> 1
		// 1101

//	
//	Scanner sc = new Scanner(System.in);
//	int ib = sc.nextInt();

		int ib = 13;
		

		// 13이라면

		while (ib >= 0) {
			int mok = ib / 2;
			ib = ib % 2;
			if (ib == 0) {
				
				System.out.println(ib);


			}

		}

//	int mok1 = ib/2;
//	int na1 = ib%2;
//	int mok2 = mok1/2;
//	int na2 = mok1%2;
//	int mok3 = mok2/2;
//	int na3 = mok2%2;
//	int mok4 = mok3/2;
//	int na4 = mok3%2;

//	int[] arr = new int[4];		
//	
//	im/2 = 몫1, 
//	im%2 = 나머지1 -> arr[3];
//	
//	몫1/2 = 몫2,
//	몫1%2 = 나머지2 -> arr[2];
//	
//	몫2/2 = 몫3
//	몫2%2 = 나머지3 -> arr[1];
//	
//	몫3>=0 -> arr[0];

	}
}
