package BOJ.silver.silver04;

import java.util.Scanner;

public class BOJ_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 동전의 가치 배열로 입력 받기
		int[] values = new int[N];
		for (int i = 0; i < values.length; i++) {
			values[i] = sc.nextInt();
		}
		
		int coinCount = 0;
		// 동전의 가치가 큰 것부터 탐색
		for (int i = values.length - 1; i >= 0; i--) {
			// 현재의 K값을 동전의 가치로 나눠서 해당 가치의 동전이 몇 개 필요한지 체크
			int coin = K / values[i];
			// 총 동전의 개수에 더하기
			coinCount += coin;
			// 현재의 값에서 사용한 동전만큼의 금액 빼주기
			K -= values[i] * coin;
		}
		System.out.println(coinCount);
	}
}
