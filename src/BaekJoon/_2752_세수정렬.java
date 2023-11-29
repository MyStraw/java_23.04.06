package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _2752_세수정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));		
		List<String> num = Arrays.asList(bw.readLine().split(" "));
		
		Collections.sort(num);		
		System.out.print(num.get(0) + " ");		
		System.out.print(num.get(1) + " ");
		System.out.print(num.get(2));		
	}
}

//이렇게 풀면 String 배열의 순서로 정리하는게 된다. 2랑 10을 비교하면 10이 먼저 나오게 됨.