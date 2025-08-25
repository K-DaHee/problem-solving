package BOJ.silver.silver04;

import java.util.Scanner;

public class BOJ_2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int[][] board = new int[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		boolean[][] isCheck = new boolean[n][n];
		
		int bingoCount = 0;
		int commandCount = 0;
		while (bingoCount < 3) {
			bingoCount = 0;
			commandCount++;
			int num = sc.nextInt();
			
			// 사회자가 부른 숫자 체크
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == num)
						isCheck[i][j] = true;
				}
			}
			
			// 가로 세로 빙고 확인
			for (int i = 0; i < n; i++) {
				int hCount = 0;	// 가로 빙고인지 카운트
				int vCount = 0;	// 세로 빙고인지 카운트
				for (int j = 0; j < n; j++) {
					if(isCheck[i][j]) hCount++;
					if(isCheck[j][i]) vCount++;
				}
				if(hCount == n) bingoCount++;
				if(vCount == n) bingoCount++;
			}
			
			// 대각선 빙고 확인
			int diagCheck1 = 0;
			int diagCheck2 = 0;
            for (int i = 0; i < n; i++) {
                if (isCheck[i][i]) diagCheck1++;
                if (isCheck[i][n - 1 - i]) diagCheck2++;
            }
            if (diagCheck1 == n) bingoCount++;
            if (diagCheck2 == n) bingoCount++;
		}
		System.out.println(commandCount);
	}
}
