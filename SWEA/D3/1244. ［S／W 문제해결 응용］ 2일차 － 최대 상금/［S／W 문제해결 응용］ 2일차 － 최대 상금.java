import java.io.*;
import java.util.*;

public class Solution {

    static char[] nums;
    static int cnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            String s = Integer.toString(num);
            nums = s.toCharArray();
            result = 0;
            dfs(0, 0);

            System.out.println("#" + t + " " + result);
        }
        br.close();
    }

    public static void dfs(int start, int depth) {
        if (depth == cnt) {
            int cur = Integer.parseInt(new String(nums));
            result = Math.max(result, cur);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                swap(i, j);
                dfs(i, depth + 1);
                swap(i, j);
            }
        }
    }

    private static void swap(int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
