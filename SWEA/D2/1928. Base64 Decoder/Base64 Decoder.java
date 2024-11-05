import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String s = br.readLine();
            String decoded = new String(Base64.getDecoder().decode(s));
            System.out.println("#" + t + " " + decoded);
        }
        br.close();
    }

}
