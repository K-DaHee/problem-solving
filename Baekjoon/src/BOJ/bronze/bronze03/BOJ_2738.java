package BOJ.bronze.bronze03;

import java.util.Scanner;

public class BOJ_2738 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] matrixA = new int[N][M];
		int[][] matrixAdd = new int[N][M];
		
		for(int i = 0; i < N; i++) {	//A 행렬 입력받기
			for(int j = 0; j < M; j++) {
				matrixA[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {	//B 행렬 입력 받으면서 A 행렬과 더한 값 바로 저장
			for(int j = 0; j < M; j++) {
				matrixAdd[i][j] = sc.nextInt() + matrixA[i][j];
				System.out.print(matrixAdd[i][j] + " ");
			}
			System.out.println();
		}
	}
}
