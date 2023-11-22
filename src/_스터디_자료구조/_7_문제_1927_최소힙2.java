package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class _7_문제_1927_최소힙2 {
	 public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    	
	        int N = Integer.parseInt(br.readLine());       
	        PriorityQueue<Integer> heap = new PriorityQueue<>();

	        for (int i = 0; i < N; i++) {
	            int x = Integer.parseInt(br.readLine());
	            if (x > 0) {
	                heap.add(x);
	            } else {	                
	                if (!heap.isEmpty()) {
	                	bw.write(String.valueOf(heap.poll()) + "\n");	                	
	                    
	                } else {
	                	bw.write("0\n");	                  
	                }
	            }
	        }

	        br.close();
	        bw.flush();
	        bw.close();
	    }
}