import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        int[] cnt = {0, 0};
        cnt[s.charAt(0) - '0']++;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                cnt[s.charAt(i) - '0']++;
            }
        }
        System.out.println(Math.min(cnt[0], cnt[1]));

        br.close();
    }

}
