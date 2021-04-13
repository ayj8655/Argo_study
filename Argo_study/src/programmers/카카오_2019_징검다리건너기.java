package programmers;

//[2, 4, 5, 3, 2, 1, 4, 2, 5, 1]	3	3

public class 카카오_2019_징검다리건너기 {
	
	public int solution(int[] stones, int k) {
        int answer = 0;

        int left = 0;
        int right = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = (left + right) / 2;   // 가능한 사람의 수

            // 가능하다면 -> 더 많은 사람이 가능한지 탐색
            if(isPossible(mid, stones, k)) {
                answer = mid;
                left = mid + 1;
            }

            // 불가능하다면 -> 수를 줄이기 위해 탐색
            else right = mid - 1;
        }

        return answer;
    }
    
    private static boolean isPossible(int mid, int[] stones, int k) {
        int cnt=0;
        for(int i=0; i<stones.length; ++i) {
            if(stones[i] - (mid-1) <= 0) cnt++;
            else cnt = 0;

            // 못건너는 돌의 연속 수가 k개가 된다면 false
            if(cnt >= k) return false;
        }

        return true;
    }
}


