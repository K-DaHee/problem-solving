package PRO.Lv3;

import java.util.Arrays;


public class PRO_42861 {
  public static void main(String[] args) {
      Solution_42861 s = new Solution_42861();
      // 테스트케이스를 활용해 코드를 실행코드 작성하시오.
  }
}
    

class Solution_42861 {
    
    // Union-Find를 위한 부모 노드 배열
    int[] parent;

    // x가 속한 집합의 루트를 찾는 함수
    private int find(int x) {
        // 자기 자신이 대표이면 자신을 반환
        if (parent[x] == x) {
            return x;
        }
        // 부모를 찾아 올라가면서 자신의 부모를 루트로 갱신
        return parent[x] = find(parent[x]);
    }

    // a가 속한 집합과 b가 속한 집합을 합치는 함수
    // 합치기에 성공하면 true, 이미 같은 집합이면 false
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 두 섬이 이미 같은 집합에 속해있다면
        if (rootA == rootB) {
            return false;
        }

        // 두 집합을 합침 
        // b의 대표가 a의 대표를 가리키도록 함
        parent[rootB] = rootA;
        return true;
    }

    public int solution(int n, int[][] costs) {
        // 모든 다리를 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // Union-Find 배열 초기화
        // 처음에는 모든 섬이 자기 자신을 루트로 가리킴
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0; // 최소 총 비용
        int bridgeCount = 0; // 건설한 다리 개수

        // 비용이 낮은 다리부터 순서대로 확인
        for (int[] edge : costs) {
            int island1 = edge[0];
            int island2 = edge[1];
            int cost = edge[2];

            // 두 섬을 합칠 수 있는지 확인
            if (union(island1, island2)) {
                // 다리 연결, 비용 추가
                totalCost += cost;
                bridgeCount++;
            }
            
            // 다리를 n-1개 연결하면 모든 섬이 연결된 것 => 종료
            if (bridgeCount == n - 1) {
                break;
            }
        }
        
        return totalCost;
    }
}