package BOJ.bronze.bronze03;

import java.util.Scanner;

public class BOJ_2566 {
	public static void main(String[] args) {
		int n = 9;
		int[][] nums = new int[n][n]; 
		
		Scanner sc = new Scanner(System.in);
		
		int max = 0, maxX = 0, maxY = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				nums[i][j] = sc.nextInt();
				if(nums[i][j] > max) {
					max = nums[i][j];
					maxY = j;
					maxX = i;
				}
			}
		}
		
		maxY += 1;
		maxX += 1;
		
		System.out.println(max);
		System.out.println(maxX + " " + maxY);
	}
}
