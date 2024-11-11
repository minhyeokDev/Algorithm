import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int cnt = 0;
            boolean[] visited = new boolean[10];
            int n = Integer.parseInt(br.readLine());
            int num = 0;

            while (cnt < 10) {
                num += n;
                String stringNum = Integer.toString(num);
                for (int i = 0; i < stringNum.length(); i++) {
                    int number = stringNum.charAt(i) - '0';
                    if (!visited[number]) {
                        visited[number] = true;
                        cnt += 1;
                    }
                }
            }

            System.out.println("#" + t + " " + num);

        }
        br.close();
    }

}
