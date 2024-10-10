import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;
        for(int truck : truck_weights) {
            while(true) {
                if(q.isEmpty()) { //큐가 비어있으면 트럭이 다리에 오름
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if(q.size() == bridge_length) { // 다리 꽉 차면 내려줌.
                    sum -= q.poll();
                } else { // 다리 길이만큼 큐가 차지 않음
                    if(sum + truck <= weight) {
                        q.add(truck);
                        time++;
                        sum += truck;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}