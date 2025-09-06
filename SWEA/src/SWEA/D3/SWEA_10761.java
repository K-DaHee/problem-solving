package SWEA.D3;

import java.util.Scanner;

public class SWEA_10761 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			// 블루와 오렌지의 시작 위치는 1이다.
			int curB = 1, curO = 1;
			// 이동하는데 각자 사용하는 시간
			int timeB = 0, timeO = 0;
			// 총 걸린 시간
            int total = 0; 
			
			for(int i = 0; i < N; i++) {
				// 이동할 로봇이 어떤 로봇인지 입력 받는다.
				String robot = sc.next();
				// 몇 번째의 버튼을 눌러야하는지 확인
				int target = sc.nextInt();
				
				if(robot.equals("B")) {
					// 뒤로 되돌아가서 버튼을 누를 수도 있어서 절댓값으로 이동 횟수 저장
					int move = Math.abs(target - curB);
					// 현재까지 걸린 총 시간과 블루 이동에 걸린 시간 중 더 큰 값 + 버튼 누르기 1
					/* 현재까지 걸린 시간과 비교하는 이유
					예를들어 O4 B3 이면
					오렌지가 이동하는 동안 블루가 이동을 같이 하고 대기를 하는 상황인데
					그 위치로 초기화가 안되어 있기 때문이다.
					따라서 오렌지가 총 걸린 시간 이후에
					대기하고 있던 상황이라면 버튼만 누르면 됨.
					*/
					timeB = Math.max(total, timeB + move) + 1;
					// 이동을 완료하고 버튼 누르기까지 한 total 시간 저장
                    total = timeB;
                    // 현재 위치를 버튼을 누른 위치로 변경
                    curB = target;
				} else if (robot.equals("O")) {
					int move = Math.abs(target - curO);
					timeO = Math.max(total, timeO + move) + 1;
                    total = timeO;
                    curO = target;
				}
			}
			
			System.out.println("#" + testCase + " " + total);
		}
	}
}
