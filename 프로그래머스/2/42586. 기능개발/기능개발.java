import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int length = progresses.length;
        for(int i = 0 ; i < length ; i++) {
            queue.add((int) Math.ceil((100.0-progresses[i])/speeds[i]));
        }
        while(!queue.isEmpty()) {
            int minDays = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek() <= minDays) {
                queue.poll();
                count++;
            }
            answer.add(count);
        }
        return answer;
    }
}