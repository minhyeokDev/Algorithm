import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] level = new Integer[n];

        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = level.length - 1; i > 0; i--) {
            if (level[i] <= level[i - 1] && level[i - 1] > 0) {
                while (true) {
                    if (level[i] > level[i - 1]) {
                        break;
                    }
                    ans++;
                    level[i - 1]--;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

}
