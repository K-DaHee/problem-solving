package BOJ.bronze.bronze01;

import java.util.Scanner;

public class BOJ_1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String s = sc.next();
            if(s.equals("0")) return;

            char[] arr = s.toCharArray();

            boolean isP = false;
            for(int i = 0; i < arr.length; i++){
                int start = i;
                int end = arr.length - i - 1;

                if(arr[start] == arr[end]) isP = true;
                else {
                    isP = false;
                    break;
                }
            }

            if(isP) System.out.println("yes");
            else System.out.println("no");
        }
    }
}