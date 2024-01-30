import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] cnt = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
            //arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        for (int i = 1; i < 10001; i++) {
            while (cnt[i] > 0) {
                bw.write(i + "\n");
                cnt[i]--;
            }
        }
/*        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }*/

        bw.flush();

    }

}