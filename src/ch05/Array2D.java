package ch05;

public class Array2D {
	public static void main(String[] args) {
//이차원배열   행열
		int[][] nums = { 
			//	  0열  1열 2열
				{ 10, 20, 30 }, //0행
				{ 40, 50, 60 }, //1행
				{ 70, 80, 90 }  //2행
		};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(nums[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
