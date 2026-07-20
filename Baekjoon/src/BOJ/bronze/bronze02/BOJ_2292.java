package BOJ.bronze.bronze02;

import java.util.Scanner;

public class BOJ_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;

        while (N > 1) {
            N -= (6 * count);
            count++;
        }

        System.out.println(count);
    }
}