package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _21773_가희와프로세스1 {
	  public static void main(String[] args) throws IOException {	    
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	   
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int totalTime = Integer.parseInt(st.nextToken());
	        int processCount = Integer.parseInt(st.nextToken());
	    
	        PriorityQueue<Process> pq = new PriorityQueue<>();	        
	     
	        for (int i = 0; i < processCount; i++) {
	            st = new StringTokenizer(br.readLine());
	            int processId = Integer.parseInt(st.nextToken());
	            int executionTime = Integer.parseInt(st.nextToken());
	            int initialPriority = Integer.parseInt(st.nextToken());
	            pq.offer(new Process(processId, executionTime, initialPriority));
	        }
	      
	        StringBuilder sb = new StringBuilder();	        
	    
	        for (int currentTime = 0; currentTime < totalTime; currentTime++) {
	            if (pq.isEmpty()) {
	                break;
	            }
	      
	            Process currentProcess = pq.poll();
	            sb.append(currentProcess.id).append("\n");

	        
	            if (currentProcess.executionTime == 1) {
	                continue;
	            }
	       
	            pq.offer(new Process(currentProcess.id, currentProcess.executionTime - 1, currentProcess.priority - 1));
	        }

	      
	        bw.write(sb.toString());
	        br.close();
	        bw.close();
	    }

	
	    static class Process implements Comparable<Process> {
	        int id, executionTime, priority;

	        Process(int id, int executionTime, int priority) {
	            this.id = id;
	            this.executionTime = executionTime;
	            this.priority = priority;
	        }
	   
	        @Override
	        public int compareTo(Process other) {
	            if (this.priority == other.priority) {
	                return this.id - other.id;
	            }
	            return other.priority - this.priority;
	        }
	    }
}
