import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            String b = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                b += s.charAt(i);
            }
            if (s.equals(b)) {
                System.out.println("#" + t + " 1");
            } else {
                System.out.println("#" + t + " 0");
            }

        }
        br.close();
    }

}
