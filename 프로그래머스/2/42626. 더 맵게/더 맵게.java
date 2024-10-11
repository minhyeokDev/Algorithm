import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length ; i++) {
            pq.add(scoville[i]);
        }
        int answer = 0;

        while(true) {
            if(pq.peek() >= K) {
                break;
            }
            if(pq.peek() < K) {
                int newScoville = pq.poll() + (pq.poll() * 2);
                pq.add(newScoville);
                answer++;
            }
            if(pq.size() < 2 && pq.peek() < K) {
                return -1;
            }
        }
        
        return answer;
    }
}