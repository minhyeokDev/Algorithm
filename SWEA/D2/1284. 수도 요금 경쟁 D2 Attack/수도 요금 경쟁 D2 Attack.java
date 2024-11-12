import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int chargeA = p * w;
            int chargeB = 0;
            if (w <= r) {
                chargeB = q;
            } else {
                chargeB = q + s * (w - r);
            }
            int answer = Math.min(chargeA, chargeB);
            System.out.println("#" + t + " " + answer);
        }
        br.close();
    }

}
