package SWEA.D2;

import java.util.Scanner;

public class SWEA_1984 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int[] arr = new int[10];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < arr.length - 1; i++) {	//가장 큰 값이 마지막으로 오게 함
				if(arr[i] > arr[i+1]) {
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			
			for(int i = arr.length - 2; i > 0 ; i--) {	//가장 작은 값이 앞으로 오게 함
				if(arr[i] < arr[i-1]) {
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
			
			double sum = 0;
			for (int i = 1; i < arr.length - 1; i++) {
				sum += arr[i];
			}
			
			int avg = (int) Math.round(sum/8);
			System.out.println("#" + testcase + " " + (int) Math.round(sum/8));
		}
		sc.close();
	}
}
