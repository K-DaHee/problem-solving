package BOJ.silver.silver03;

import java.util.Scanner;

public class BOJ_4779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){    // 입력이 여러줄
            int n = sc.nextInt();   // n 입력
            int size = (int) Math.pow(3, n);    // 3^n
            String arr = "-".repeat(size);

            String result = loop(arr, arr.length());

            System.out.println(result);
        }
    }

    private static String loop(String arr, int size){
        if(size == 1) return arr;

        int len = size / 3;

        String left = arr.substring(0, len);    // 왼쪽
        String mid = " ".repeat(len);   // 중간은 공백
        String right = arr.substring(len*2, len*3); //오른쪽

        return loop(left, left.length()) + mid + loop(right, right.length());
    }
}
