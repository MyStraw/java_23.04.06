package Chap5_재귀알고리즘;

import java.util.Stack;

public class MazingProblemCPP3 {

	static class Items {
		int x, y, dir;

		Items(int x, int y, int dir) {
			this.x = x;
			this.y = dir;
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

	public static void main(String[] args) {
		int[][] maze = new int[100][100];
		int[][] mark = new int[100][100];

		int[][] input = {{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, 
				
		};

		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets(0, 0);

		moves[0] = new Offsets(-1, 0);
		moves[1] = new Offsets(-1, 1);
		moves[2] = new Offsets(0, 1);
		moves[3] = new Offsets(1, 1);
		moves[4] = new Offsets(1, 0);
		moves[5] = new Offsets(1, -1);
		moves[6] = new Offsets(0, -1);
		moves[7] = new Offsets(-1, -1);

		// Initialize maze and mark
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

		// Display maze and mark arrays
		System.out.println("maze[12,15]:");
		for (int i = 0; i <= 13; i++) {
			for (int j = 0; j <= 16; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}

		path(maze, mark, 12, 15);

		// Display mark array
		System.out.println("mark:");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void path(int[][] maze, int[][] mark, int m, int p) {
	    mark[1][1] = 1;
	    Stack<Items> stack = new Stack<>();
	    Items temp = new Items(1, 1, 2);
	    stack.push(temp);

	    while (!stack.isEmpty()) {
	        temp = stack.pop();
	        int i = temp.x, j = temp.y, d = temp.dir;
	        while (d < 8) {
	            int g = i + moves[d].a;
	            int h = j + moves[d].b;
	            if ((g == m) && (h == p)) {
	                System.out.println("Path found.");
	                return;
	            }

	            if (g >= 0 && g < maze.length && h >= 0 && h < maze[0].length && (maze[g][h] == 0) && (mark[g][h] == 0)) {
	                mark[g][h] = 1;
	                temp = new Items(i, j, d + 1);
	                stack.push(temp);
	                i = g;
	                j = h;
	                d = 0;
	            } else {
	                d++;
	            }
	        }
	    }
	    System.out.println("No path in maze.");
	}
}
