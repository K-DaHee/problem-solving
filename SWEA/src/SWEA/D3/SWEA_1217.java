package SWEA.D3;

import java.util.Scanner;

public class SWEA_1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println("#" + t + " " + solve(n, m, 1));
		}
	}
	
	private static int solve(int n, int m, int num) {
		if(m == 0) return num;
		num *= n;
		return solve(n, m - 1, num);
	}
}
