import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            int count = 0;
            int prev = 0;

            for (int i = 0; i < s.length(); i++) {
                int cur = s.charAt(i) - '0';
                if (prev != cur) {
                    prev = cur;
                    count++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
        br.close();
    }

}
