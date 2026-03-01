package BOJ.bronze.bronze02;

import java.util.Scanner;

public class BOJ_2231_2 {
    static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int d = String.valueOf(N).length();

        int start = N - 9 * d;
        if (start < 1) start = 1;

        int answer = 0;

        for (int M = start; M < N; M++) {
            int sum = M + digitSum(M);
            if (sum == N) {
                answer = M;
                break;
            }
        }

        System.out.println(answer);
    }
}
