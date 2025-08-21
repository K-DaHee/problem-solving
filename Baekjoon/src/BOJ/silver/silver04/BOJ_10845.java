package BOJ.silver.silver04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    Queue<Integer> queue = new LinkedList<>();
	    int last = -1;
			;
	    for (int i = 0; i < N; i++) {
	        String command = sc.next();
	
	        switch (command) {
	            case "push":
	            int value = sc.nextInt();
				queue.add(value);
				last = value;
				break;
				
			case "pop":
				if (queue.isEmpty()) {
				    System.out.println(-1);
				} else {
				    System.out.println(queue.remove());
				}
				break;
				
			case "size":
				System.out.println(queue.size());
				break;
				
			case "empty":
				System.out.println(queue.isEmpty() ? 1 : 0);
				break;
				
			case "front":
				if (queue.isEmpty()) {
				    System.out.println(-1);
				} else {
				    System.out.println(queue.peek());
				}
				break;
			case "back":
				if (queue.isEmpty()) {
				    System.out.println(-1);
				} else {
				    System.out.println(last);
				}
				break;
            }
        }
        sc.close();
	}
}
