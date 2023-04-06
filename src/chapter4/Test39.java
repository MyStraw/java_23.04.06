package chapter4;

public class Test39 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4,5},
				{6,7,8,9,10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) { // 그러니까 행(세로줄)갯수 몇개냐
			for(int j = 0; j < arr[i].length; j++) { // 그러니까 행에 있는 열(가로줄) 갯수 몇개냐
				if(i == j)  //11,22,33 이런것만 sum해서 출력해라 -> i랑 j랑 같은것만 더하는 결과를 원한다.
					sum = sum+arr[i][j];  //arr[][] 행렬 이 값안의 수를 더하란겨
			}		
		}
		System.out.println("합계 : " + sum);
	}
}
