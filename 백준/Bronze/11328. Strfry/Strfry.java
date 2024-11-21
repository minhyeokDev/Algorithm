import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            boolean ans = true;

            if (a.length != b.length) {
                System.out.println("Impossible");
                continue;
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    ans = false;
                }
            }
            if (ans) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }

        br.close();
    }


}
