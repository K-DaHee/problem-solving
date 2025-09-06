package PRO.Lv1;

import java.util.Stack;

public class PRO_64061 {
	public static void main(String[] args) {
		Solution_64061 s = new Solution_64061();
		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		int answer = s.solution(board, moves);
		System.out.println(answer);
	}
}

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
    	Stack<Integer> stack = new Stack<>();
    	int answer = 0;
    	for (int i : moves) {
    		int j = 0;
    		while(j < board.length) {
    			if(board[j][i - 1] == 0) j++;
    			else {
    				if(stack.isEmpty() || stack.peek() != board[j][i - 1]) {
    					stack.push(board[j][i - 1]);
    					board[j][i - 1] = 0;
    					break;
    				} else if (stack.peek() == board[j][i - 1]) {
    					board[j][i - 1] = 0;
    					stack.pop();
    					answer += 2;
    					break;
    				}
    			}
    		}
		}
        return answer;
    }
}