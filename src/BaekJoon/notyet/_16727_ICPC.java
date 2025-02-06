package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16727_ICPC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] match1 = br.readLine().split(" ");
		int p1 = Integer.parseInt(match1[0]);
		int s1 = Integer.parseInt(match1[1]);

		String[] match2 = br.readLine().split(" ");
		int s2 = Integer.parseInt(match2[0]);
		int p2 = Integer.parseInt(match2[1]);

		int aggregatePersepolis = p1 + p2;
		int aggregateEsteghlal = s1 + s2;

		if (aggregatePersepolis > aggregateEsteghlal) {
			System.out.println("Persepolis");
		} else if (aggregateEsteghlal > aggregatePersepolis) {
			System.out.println("Esteghlal");
		} else {
			int awayGoalsPersepolis = p2;
			int awayGoalsEsteghlal = s1;

			if (awayGoalsPersepolis > awayGoalsEsteghlal) {
				System.out.println("Persepolis");
			} else if (awayGoalsEsteghlal > awayGoalsPersepolis) {
				System.out.println("Esteghlal");
			} else {
				System.out.println("Penalty");
			}
		}
	}

}
