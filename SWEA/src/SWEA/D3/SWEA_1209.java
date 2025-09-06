package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 1; T <= 10; T++) {
			int testCase = Integer.parseInt(br.readLine());

			int n = 100;
			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			// 가로 합
			for (int i = 0; i < arr.length; i++) {
				int sum = 0;
				for (int j = 0; j < arr.length; j++) {
					sum += arr[i][j];
				}
				max = Math.max(max, sum);
			}
			
			// 세로 합
			for (int j = 0; j < arr.length; j++) {
				int sum = 0;
				for (int i = 0; i < arr.length; i++) {
					sum += arr[i][j];
				}
				max = Math.max(max, sum);
			}
			
			// 대각선 합
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < arr.length; i++) {
				sum1 += arr[i][i];
				sum2 += arr[i][n - 1 - i];
			}
			max = Math.max(max, Math.max(sum1, sum2));
			
			System.out.println("#" + testCase + " " + max);
		}
	}
}
