package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B번2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 최대 팀 인원 수

		st = new StringTokenizer(br.readLine());

		int V0 = Integer.parseInt(st.nextToken()); // 재원이의 꿈 스탯
		int P0 = Integer.parseInt(st.nextToken()); // 재원이의 열정 스탯
		int S0 = Integer.parseInt(st.nextToken()); // 재원이의 나눔 스탯

		int JaeWonSum = V0 + P0 + S0; // 재원이의 스탯 합

		Status[] students = new Status[N]; // 학생들의 스탯을 저장할 배열

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			int sum = V + P + S;

			// 학생의 스탯을 배열에 저장
			students[i - 1] = new Status(V, P, S, sum, i);
		}

		// 재원이보다 스탯 합이 큰 학생은 제외
		Status[] filteredStudents = Arrays.stream(students).filter(student -> student.sum <= JaeWonSum)
				.toArray(Status[]::new);

		// 합에 따라 내림차순으로 정렬
		Arrays.sort(filteredStudents, (a, b) -> Integer.compare(b.sum, a.sum));

		// 결과 저장을 위한 배열
		int[] team = new int[M];
		int count = 0;

		// 재원이 번호 추가
		team[count++] = 0;

		// 최대 M명까지 팀원 선정
		for (int i = 0; i < filteredStudents.length && count < M; i++) {
			team[count++] = filteredStudents[i].Number;
		}

		// 결과 출력
		for (int i = 0; i < count; i++) {
			System.out.print(team[i] + " ");
		}
	}

	static class Status {
		int V;
		int P;
		int S;
		int sum;
		int Number;

		Status(int V, int P, int S, int sum, int Number) {
			this.V = V;
			this.P = P;
			this.S = S;
			this.sum = sum;
			this.Number = Number;
		}
	}

}
