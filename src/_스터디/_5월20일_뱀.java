package _스터디;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5월20일_뱀 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = 0;
		
		Queue<Integer>[] queueArray = new LinkedList[10];
		
		for(int i = 0; i<N; i++) {
			queueArray[i] = new  LinkedList<>();
		}
		
		queueArray[0].add(1);
				
		System.out.println(queueArray[0]);
	}

}
