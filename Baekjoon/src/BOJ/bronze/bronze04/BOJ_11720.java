package BOJ.bronze.bronze04;

import java.util.Scanner;

public class BOJ_11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String nums = sc.next();
		String[] num = nums.split("");
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(num[i]);
		}
		System.out.println(sum);
		sc.close();
	}
}