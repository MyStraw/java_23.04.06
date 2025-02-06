package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _23028_5학년은다니기싫어요 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int A = Integer.parseInt(input[1]);
		int B = Integer.parseInt(input[2]);

		int remainingSemesters = 8 - N;

		int neededMajor = Math.max(0, 66 - A);
		int neededTotal = Math.max(0, 130 - B);

		int[][] courses = new int[10][2];
		for (int i = 0; i < 10; i++) {
			input = br.readLine().split(" ");
			courses[i][0] = Integer.parseInt(input[0]);
			courses[i][1] = Integer.parseInt(input[1]);
		}

		boolean possible = canGraduate(remainingSemesters, neededMajor, neededTotal, courses);

		System.out.println(possible ? "Nice" : "Nae ga wae");
	}

	private static boolean canGraduate(int remainingSemesters, int neededMajor, int neededTotal, int[][] courses) {
		if (remainingSemesters <= 0 && (neededMajor > 0 || neededTotal > 0)) {
			return false;
		}

		int currentMajor = 0;
		int currentTotal = 0;

		for (int i = 0; i < remainingSemesters; i++) {
			int semesterTotal = 0;
			int majorCourses = Math.min(6, courses[i][0]);

			if (majorCourses > 6) {
				majorCourses = 6;
			}

			int takenMajor = Math.min(majorCourses, 6 - semesterTotal);
			currentMajor += takenMajor * 3;
			currentTotal += takenMajor * 3;
			semesterTotal += takenMajor;

			int remainingSlots = 6 - semesterTotal;
			int nonMajorCourses = Math.min(remainingSlots, courses[i][1]);
			currentTotal += nonMajorCourses * 3;
		}

		return currentMajor >= neededMajor && currentTotal >= neededTotal;
	}

}
