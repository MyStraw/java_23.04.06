package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6월17일_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();		
		
		boolean k = true;
		
		Stack<Character> keyloger = new Stack<>();
		Stack<Character> back = new Stack<>();
		for (int i = 0; i < N; i++) {
			String L = br.readLine();
			keyloger.clear();
			for (char c : L.toCharArray()) {
				keyloger.push(c);				
				switch (keyloger.peek()) {				
				case '<':					
					keyloger.pop();
					break;
				case '>':					
					keyloger.pop();
					break;
				case '-':					
					keyloger.pop();
					keyloger.pop();
					break;
				}
				if(!keyloger.isEmpty())				
				System.out.println(keyloger.peek());
			}
		}
	}
}

