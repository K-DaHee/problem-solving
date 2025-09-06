package SWEA.D2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_14229 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/SWEA/D2/input.txt"));
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[1000000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		int pivot = 0;
		
		int idx = 0;
		int big = 0;
		int small = 0;
		while(big <= small) {
			pivot = nums[idx];
			for (int i = idx; i < nums.length; i++) {
				if(nums[i] > pivot) {
					big = i;
					break;
				}
			}
			for (int i = nums.length - 1; i > idx; i--) {
	            if (nums[i] < pivot) {
	                small = i;
	                break;
	            }
	        }
			
			int temp = nums[big];
			nums[big] = nums[small];
			nums[small] = temp;
			
			temp = nums[small];
			nums[small] = nums[idx];
			nums[idx] = temp;
			
			idx = big;
		}
		
		System.out.println(nums[5000]);
	}
}
