package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1913_회의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}

		Arrays.sort(meetings); // 끝나는 시간을 기준으로 회의를 정렬합니다.

		int count = 0; // 선택된 회의의 수
		int prevEndTime = 0; // 이전 회의의 끝나는 시간

		for (int i = 0; i < N; i++) {
			// 현재 회의의 시작 시간이 이전 회의의 끝나는 시간보다 크거나 같다면, 회의를 선택합니다.
			if (meetings[i].start >= prevEndTime) {
				prevEndTime = meetings[i].end; // 이전 회의의 끝나는 시간을 업데이트합니다.
				count++; // 선택된 회의의 수를 증가시킵니다.
			}
		}

		System.out.println(count); // 최대 사용할 수 있는 회의의 최대 개수를 출력합니다.
	}

}

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	// 끝나는 시간을 기준으로 정렬합니다. 만약 끝나는 시간이 같다면, 시작 시간이 빠른 순으로 정렬합니다.
	@Override
	public int compareTo(Meeting o) {
		if (this.end == o.end) {
			return this.start - o.start;
		}
		return this.end - o.end;
	}
}