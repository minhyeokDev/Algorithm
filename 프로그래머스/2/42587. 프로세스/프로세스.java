import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : priorities) {
            pq.offer(num);
        }
        int answer = 0;
        
        while(!pq.isEmpty()) {
            for(int i = 0 ; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                    if(i== location) {
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}