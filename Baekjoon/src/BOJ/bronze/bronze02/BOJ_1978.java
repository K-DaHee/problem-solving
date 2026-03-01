package BOJ.bronze.bronze02;

import java.util.Scanner;

public class BOJ_1978 {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;  // 짝수는 바로 탈락

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(isPrime(num)){
                count++;
            }
        }

        System.out.println(count);
    }
}
