package _코테준비_;

import java.util.ArrayList;
import java.util.List;

public class 배열순회_4 {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix.length == 0)
			return result;
		int rowBegin = 0, rowEnd = matrix.length - 1;
		int colBegin = 0, colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// 오른쪽으로 이동
			for (int j = colBegin; j <= colEnd; j++) {
				result.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// 아래로 이동
			for (int j = rowBegin; j <= rowEnd; j++) {
				result.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// 왼쪽으로 이동
				for (int j = colEnd; j >= colBegin; j--) {
					result.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// 위로 이동
				for (int j = rowEnd; j >= rowBegin; j--) {
					result.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}

}

//최상: 나선형 배열 순회
//
//문제: M x N 크기의 2차원 배열을 나선형으로 순회하고, 순회한 결과를 리스트로 반환하라.
