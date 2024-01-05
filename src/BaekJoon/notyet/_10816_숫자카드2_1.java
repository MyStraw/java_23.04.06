package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816_숫자카드2_1 {
	
    public static HashMap<Integer, Integer> cardMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
           
            cardMap.put(card[i], cardMap.getOrDefault(card[i], 0) + 1);
        }

        Arrays.sort(card); 

        int M = Integer.parseInt(br.readLine());
        int[] check = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            int count = findCardCount(card, check[i]);
            bw.write(count + " ");
        }

        bw.flush();
        bw.close();
    
    }

   
    public static int findCardCount(int[] card, int target) {
        if (!cardMap.containsKey(target)) {
            return 0;
        }
        
        int start = lower(card, target);
        int end = upper(card, target);
        return end - start;
    }

  
    public static int lower(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

   
    public static int upper(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

}
