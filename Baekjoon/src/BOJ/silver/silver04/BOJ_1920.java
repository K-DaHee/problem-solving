package BOJ.silver.silver04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 기본 배열로 하면 시간초과 발생!
		HashSet<Integer> A = new HashSet<>();	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));	// HashSet에 입력받은 숫자 배열 저장
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {	// M(타겟의 크기)만큼 반복
            int target = Integer.parseInt(st.nextToken());
            if (A.contains(target)) {	// HashSet에 타겟이 포함되어 있다면 1, 포함되어 있지 않으면 0
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
		
		/*	시간초과 수정 전 코드
			int[] A = new int[N];	// A 배열
			StringTokenizer st = new StringTokenizer(br.readLine());	// 한줄 읽어오기
			for (int i = 0; i < N; i++) {	// 읽어온 줄 하나씩 쪼개서 A[i]에 넣기
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());	// 일단 한줄 입력 받아놓기
			
			for (int i = 0; i < M; i++) {	// M 만큼 반복하면서
				boolean check = false;	// 포함하고 있는지 체크할 변수
				int target = Integer.parseInt(st.nextToken());	// 토큰 한개씩 꺼내면서 타겟으로 지정
				for (int j = 0; j < A.length; j++) {	// 반복 돌면서 
					if(target == A[j]) {	// A에 타겟이 있으면 체크 true, 반복 멈춤
						check = true;
						break;
					}
				}
				if (check) {	// 체크가 true면 1, false면 0 출력
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		 */
	}
}
