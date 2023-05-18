package Chap5_재귀알고리즘;

import java.util.Stack;

public class MazingProblemCPP2 {

	static class Items {
		int x, y, dir;

		Items(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static class Offsets {
		int a, b;

		Offsets(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static Offsets[] moves = new Offsets[8];

	static int[][] maze = new int[100][100];
	static int[][] mark = new int[100][100];

	
	
	static void path(int m, int p) {
		mark[1][1] = 1;
		Stack<Items> stack = new Stack<>();
		Items temp = new Items(1, 1, 1);
		stack.push(temp);

		while (!stack.isEmpty()) {
			temp = stack.pop();
			int i = temp.x;
			int j = temp.y;
			int d = temp.dir;

			while (d < 8) {
				int g = i + moves[d].a;
				int h = j + moves[d].b;

				if ((g == m) && (h == p)) {
					System.out.println("Path found.");
					return;
				}

				if ((maze[g][h] == 0) && (mark[g][h] == 0)) {
					mark[g][h] = 1;
					temp.x = i;
					temp.y = j;
					temp.dir = d + 1;
					stack.push(temp);
					i = g;
					j = h;
					d = 0;
				} else
					d++;
			}
		}
		System.out.println("No path in maze.");
	}

	public static void main(String[] args) {

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };

		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);
		moves[0].a = -1;
		moves[0].b = 0;
		moves[1].a = -1;
		moves[1].b = 1;
		moves[2].a = 0;
		moves[2].b = 1;
		moves[3].a = 1;
		moves[3].b = 1;
		moves[4].a = 1;
		moves[4].b = 0;
		moves[5].a = 1;
		moves[5].b = -1;
		moves[6].a = 0;
		moves[6].b = -1;
		moves[7].a = -1;
		moves[7].b = -1;

//		moves[0] = new Offsets(-1, 0);
//        moves[1] = new Offsets(-1, 1);
//        moves[2] = new Offsets(0, 1);
//        moves[3] = new Offsets(1, 1);
//        moves[4] = new Offsets(1, 0);
//        moves[5] = new Offsets(1, -1);
//        moves[6] = new Offsets(0, -1);
//        moves[7] = new Offsets(-1, -1);

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (j == 0) || (i == 13) || (j == 16))
					maze[i][j] = 1;
				else {
					maze[i][j] = input[i - 1][j - 1];
				}
				mark[i][j] = 0;

			}
		}
		System.out.println("maze[12,15]::");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");

			}
			System.out.println();
		}

		path(12, 15);		
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");

			}
			System.out.println();
		}

	}
}
