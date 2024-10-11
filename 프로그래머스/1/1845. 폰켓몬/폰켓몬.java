import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++) {
            map.add(nums[i]);
        }
        if(map.size() > max ) {
            return max;
        } else {
            return map.size();
        }
    }
}