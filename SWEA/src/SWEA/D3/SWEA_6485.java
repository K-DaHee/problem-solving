package SWEA.D3;

import java.util.Scanner;

public class SWEA_6485 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			int[][] AB = new int[N][2];
			for (int i = 0; i < AB.length; i++) {
				AB[i][0] = sc.nextInt();
				AB[i][1] = sc.nextInt();
			}
			
			int P = sc.nextInt();
			int[] C = new int[P];
			for (int i = 0; i < C.length; i++) {
				C[i] = sc.nextInt();
			}
			
			int[] count = new int[P];
			for (int i = 0; i < C.length; i++) {
				for (int j = 0; j < AB.length; j++) {
					if(C[i] >= AB[j][0] && C[i] <= AB[j][1]) count[i]++;
				}
			}
			
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < count.length; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println();
		}
	}
}
