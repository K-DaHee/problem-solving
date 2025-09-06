package SWEA.D5;

import java.util.Scanner;

public class SWEA_7793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] arr = new char[M][N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.next().toCharArray();
			}
			
			int[] dx = {0, 0, -1, 1};
			int[] dy = {-1, 1, 0, 0};
			
			boolean[][] isDemon = new boolean[M][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					// 악마 확장
					if(arr[i][j] == '*') {
						isDemon[i][j] = true;
						for (int d = 0; d < 4; d++) {
							int nx = j + d;
							int ny = i + d;
							if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
							isDemon[nx][ny] = true;
						}
					}
					
					// 수연이 악마 피해서 이동
					
				}
			}
		}
	}
}
