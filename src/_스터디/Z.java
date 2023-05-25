package _스터디;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Z {

	static int[][] Z;

	private static final int x = 0;
	private static final int y = 0;

	public static Point p = new Point(x, y);
	public static Queue<Point> que = new LinkedList<>();

	static void DrawZ(int[][] Z, int x, int y, int z) {
		int num = 0;
		
		if (z == 1) {
			num++;			
			p.x = x;
			p.y = y;
			que.add(p);		
			Z[x][y] = num;
			return;
		}

		
		int size = z / 2;
		int count = 0;
		for (int i = x; i < x + z; i += size) {
			for (int j = y; j < y + z; j += size) {
				count++;
			//	if (count == 4) {
					DrawZ(Z,i, j, size);
				//}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int z = 1 << N; // 2의 3승 = Math.pow(2, 3); 이건 더블
		Z = new int[z][z];
		
		DrawZ(Z, 0, 0, z);

		for (int i = 0; i < z; i++) {
			for (int j = 0; j < z; j++) {
				System.out.print(Z[i][j]);
			}
			System.out.println();
		}

		

		System.out.println(que.peek());

	}

}
