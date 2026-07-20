package BOJ.bronze.bronze01;

import java.util.Scanner;

public class BOJ_1259_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String s = sc.next();
            if(s.equals("0")) return;

            boolean isP = true;
            int len = s.length();

            for(int i = 0; i < len/2; i++){
                int start = i;
                int end = len - i - 1;

                if(s.charAt(start) != s.charAt(end)) {
                    isP = false;
                    break;
                }
            }

            if(isP) System.out.println("yes");
            else System.out.println("no");
        }
    }
}