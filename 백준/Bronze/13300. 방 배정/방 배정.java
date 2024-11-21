import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[][] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        students = new int[2][7];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            students[s][y]++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                double temp = (double) students[i][j] / k;
                ans += (int) Math.ceil(temp);
            }
        }

        System.out.println(ans);

        br.close();

    }

}
