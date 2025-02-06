package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class D번_시설물사용신청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long M = (long) Math.ceil((long) n * n / 4.0);
		System.out.println(M);

		if (M > 1_000_000)
			return;		

		PriorityQueue<Integer> endTimes = new PriorityQueue<>();
		List<List<int[]>> rooms = new ArrayList<>();

		for (int diff = 1; diff < n; diff++) {
			for (int start = 1; start + diff <= n; start++) {
				int end = start + diff;
				boolean assigned = false;

				for (int i = 0; i < rooms.size(); i++) {
					if (endTimes.peek() <= start) {
						endTimes.poll();
						rooms.get(i).add(new int[] { start, end });
						endTimes.add(end);
						assigned = true;
						break;
					}
				}

				if (!assigned) {
					endTimes.add(end);
					List<int[]> newRoom = new ArrayList<>();
					newRoom.add(new int[] { start, end });
					rooms.add(newRoom);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (List<int[]> room : rooms) {
			sb.append(room.size());
			for (int[] time : room) {
				sb.append(" ").append(time[0]).append(" ").append(time[1]);
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}
