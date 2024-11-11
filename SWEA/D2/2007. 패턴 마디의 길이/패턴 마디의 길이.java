import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            for (int i = 1; i < s.length(); i++) {
                String a = s.substring(0, i);
                String b = s.substring(i, i + i);
                if (a.equals(b)) {
                    System.out.println("#" + t + " " + a.length());
                    break;
                }
            }

        }
        br.close();
    }

}
