package chapter5;

// 3*4 행렬과 4*3 행렬을 선언하고 두 행렬의 곱을 계산해서 출력
public class mission {

	public static void main(String[] args) {
		
		int[][] x = {{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12}};
					
		int[][] y = {{1,2,3},
					{4,5,6},
					{7,8,9},
					{10,11,12}};		
					
		
						
		for(int i = 0 ; i < 3 ; i++) {
			for(int k = 0 ; k < 3 ; k++) {
				int sum = 0;
				for(int j = 0 ; j < 4 ; j++) {
					
				sum = sum + x[i][j] * y[j][k];
				}
				System.out.print(sum + "\t"); // result = sum[i][k]
			}
				
			//for(int i = 0 ; i < 3 ; i++) {
				//for(int k = 0 ; k < 3 ; k++)
			//System.out.println(result);
		
			System.out.println();
		}
	}
			
	
		

}
