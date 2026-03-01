package BOJ.bronze.bronze02;

import java.util.*;

public class BOJ_2231 {

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

        int answer = 0;

        for (int M = 1; M < N; M++) {
            if (M + digitSum(M) == N) {
                answer = M;
                break;
            }
        }

        System.out.println(answer);
    }
}