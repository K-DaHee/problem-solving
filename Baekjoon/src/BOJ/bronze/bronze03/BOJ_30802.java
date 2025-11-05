package BOJ.bronze.bronze03;

import java.util.Scanner;

public class BOJ_30802 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 참가자 수 N
		int[] Tshirt = new int[6];	// 사이즈 별 신청자 수
		for (int i = 0; i < Tshirt.length; i++) {
			Tshirt[i] = sc.nextInt();
		}
		int T = sc.nextInt();	// 티셔츠 묶음
		int P = sc.nextInt();	// 펜 묶음
		
		int tCount = 0;
		for (int i = 0; i < Tshirt.length; i++) {
			if(Tshirt[i] % T == 0) tCount += Tshirt[i] / T;
			else tCount += Tshirt[i] / T + 1;	// 묶음으로 나눈 수 + 1 만큼 주문하는 것이 최소 묶음
		}
		
		int pCount = N / P;	// 펜 최대 묶음 수
		int pen = N % P;	// 펜 낱개 수
		
		System.out.printf("%d\n%d %d", tCount, pCount, pen);
	}
}
