package 코테;

import java.util.Arrays;

public class B_ms_ {
	public static void main(String[] args) {
		// 예시 입력
		int[][] delays = { { 2423, 10 }, { 3423, 30 }, { 1, 40 }, { 450, 50 }, { 1200, 60 }, { 2781, 100 } };
		int a = 2, b = 1000;

		int[] result = getMaxParticipants(delays, a, b);
		System.out.println(Arrays.toString(result)); // 예상 출력: [3, 2]
	}

	public static int[] getMaxParticipants(int[][] delays, int a, int b) {
		int maxParticipants = 0;
		int selectedServer = 1;

		for (int server = 0; server < delays[0].length; server++) {
			int[] serverDelays = new int[delays.length];
			for (int participant = 0; participant < delays.length; participant++) {
				serverDelays[participant] = delays[participant][server];
			}
			Arrays.sort(serverDelays);

			int currentMax = 0;
			for (int i = 0; i < serverDelays.length; i++) {
				int count = 1;
				for (int j = i + 1; j < serverDelays.length; j++) {
					if ((double) serverDelays[j] / serverDelays[i] < a && serverDelays[j] - serverDelays[i] < b) {
						count++;
					}
				}
				currentMax = Math.max(currentMax, count);
			}

			if (currentMax > maxParticipants) {
				maxParticipants = currentMax;
				selectedServer = server + 1;
			}
		}

		return new int[] { maxParticipants, selectedServer };
	}

}

/*
대회에 n명이 참가한다
대회서버는 1~m번이 있고, 참가자가 이 서버를 이용하는데
이 서버와 참가자간에는 통신지연이 발생한다.
서버 m개중 1개를 선택하여 n명의 참가자중 최대한 많은 참가자를 초대하려한다.

다만, 초대할때 조건이 있는데
참가자간에 통신지연이 a배이상, b초 이상 차이가 나선 안된다.
(1초 = 1000ms)

아래 표 단위(ms)
        서버1   서버2
후보1    2423    10
후보2    3423    30
후보3       1    40
후보4     450    50
후보5    1200    60
후보6    2781   100

입력값
a, b, delay[][]

2<= a <= 10
1<= b <= 10

1<=delay[i]<=500,000
1<=delay[][]<=1,000,000

결과는 [최대 후보수, 서버번호]를 출력
위의 예제의 답은 [3,2]
*/
