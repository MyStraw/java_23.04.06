package Chap5_재귀알고리즘;
//입구[1][1]
//출구 : 도달
//대각선도 갈수있다.
enum Directions {N,Ne,E,SE,S,SW,W,NW}

class Items{
	int x;
	int y;
	int dir;	
}

class Offesets {
	int a;
	int b;
}
//생성자 만들어야.



public class 미로찾기 {
	static Offsets[] move = new Offesets[8]; // start
	
	public static void path(int[][] maze, int[][] mark) {
		
		mark[1][1]=1;
		StackList st = new StackList(50);
		Items temp = new Items(0,0,0);
	}
	
	
	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];
		
		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },				
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };
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
		
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
	}
}

