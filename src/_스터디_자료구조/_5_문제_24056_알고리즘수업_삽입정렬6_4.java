package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_24056_알고리즘수업_삽입정렬6_4 {
	
	private static boolean insert(int[] A, int[] B) {
		for (int i = 0; i < B.length; i++) {
			// 현재 요소보다 큰 값이 왼쪽에 
			for (int j = 0; j < i; j++) {
				if (B[j] > B[i])
					return false;
			}
			// 중복 값 확인 // 근데 이러면 또 반복문만 무한..똑같다.
			if (i > 0 && B[i] == B[i - 1]) {
				boolean validDuplicate = false;
				for (int j = 0; j < A.length; j++) {
					if (A[j] == B[i]) {
						validDuplicate = true;
						break;
					}
				}
				if (!validDuplicate)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] A = new int[dataSize];
		int[] B = new int[dataSize];
		StringTokenizer aToken = new StringTokenizer(br.readLine());
		StringTokenizer bToken = new StringTokenizer(br.readLine());

		for (int i = 0; i < dataSize; i++) {
			A[i] = Integer.parseInt(aToken.nextToken());
			B[i] = Integer.parseInt(bToken.nextToken());
//			System.out.print(A[i] + " ");
//			System.out.println(B[i]);
		}

		if (insert(A, B)) {
			bw.write(1);
			System.out.println(1);
		} else {
			System.out.println(0);
		}		
	}
}

