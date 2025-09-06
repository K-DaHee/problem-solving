package SWEA.D3;

import java.util.Scanner;

public class SWEA_1217_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) { // 10개의 테스트 케이스 처리
			int t = sc.nextInt(); // 테스트 케이스 번호
			int n = sc.nextInt(); // 밑
			int m = sc.nextInt(); // 지수

			long result = pow(n, m);

			System.out.println("#" + t + " " + result);
		}
	}

	static long pow(int n, int m) {
		if(m == 0) return 1;	// 지수가 0이 되면 종료

		long half = pow(n, m / 2);
		
		long result = half * half;
		
		if (m % 2 == 1) {
            result *= n;
        }
		
		return result;
	}

}
