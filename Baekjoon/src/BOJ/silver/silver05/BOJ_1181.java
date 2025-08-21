package BOJ.silver.silver05;

import java.util.Scanner;

public class BOJ_1181 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        // 길이순 + 사전순 정렬 (버블 정렬 방식)
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                boolean swap = false;

                if (arr[j].length() > arr[j + 1].length()) {
                    swap = true;
                } else if (arr[j].length() == arr[j + 1].length()) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        swap = true;
                    }
                }

                if (swap) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 중복 제거하며 출력
        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }

        sc.close();
    }
}
