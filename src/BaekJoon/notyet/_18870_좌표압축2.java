package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _18870_좌표압축2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> originalList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            originalList.add(num);
        }
       
        LinkedHashSet<Integer> sortedSet = new LinkedHashSet<>(originalList);
        List<Integer> sortedList = new LinkedList<>(sortedSet);
        Collections.sort(sortedList);
     
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sortedList.size(); i++) {
            indexMap.put(sortedList.get(i), i);
        }
        
        for (int num : originalList) {
            bw.write(indexMap.get(num) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
