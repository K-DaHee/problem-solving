package BOJ.silver.silver05;

import java.util.Scanner;

public class BOJ_10709 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();

		char[][] cloud = new char[H][W];

		// 결과를 저장할 배열
		int[][] answer = new int[H][W];

		for (int i = 0; i < H; i++) {
			cloud[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < H; i++) {
			int cloudTimer = -1;
			for (int j = 0; j < W; j++) {
				// 현재 칸에 구름이 있다면
				if (cloud[i][j] == 'c') {
					cloudTimer = 0; // 타이머를 0으로 리셋
					answer[i][j] = 0;
				}
				// 현재 칸이 비어있고, 이전에 구름을 본 적이 있다면
				else if (cloudTimer != -1) {
					cloudTimer++; // 타이머 1 증가
					answer[i][j] = cloudTimer;
				}
				// 현재 칸이 비어있고, 아직 구름을 본 적이 없다면
				else {
					answer[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}
}
