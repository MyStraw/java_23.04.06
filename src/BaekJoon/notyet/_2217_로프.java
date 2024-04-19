package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2217_로프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer rope[] = new Integer [N];		

		for (int i = 0; i < N; i++) {
			int weight = Integer.parseInt(br.readLine());
			rope[i] = weight;
		}
		
		Arrays.sort(rope, (a, b) -> b - a);
		
		int maxWeight = 0; 
        for(int i = 0; i < N; i++) {
            int weight = rope[i] * (i + 1); 
            maxWeight = Math.max(maxWeight, weight); 
        }   
        
        System.out.println(maxWeight); 
	}

}
