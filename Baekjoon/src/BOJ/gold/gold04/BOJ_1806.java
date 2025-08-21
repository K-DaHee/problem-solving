package BOJ.gold.gold04;

import java.util.Scanner;

public class BOJ_1806 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열 길이
        int S = sc.nextInt(); // 목표 합

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); // 수열 입력
        }

        int start = 0, end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                minLen = Math.min(minLen, end - start);
                sum -= arr[start++];
            } else if (end == N) {
                break;
            } else {
                sum += arr[end++];
            }
        }

        // 조건을 만족하는 부분합이 없으면 0 출력
        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
