import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                break;
            }
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int s = 1; //arr[start]와 중복되는 값이 몇개인가?
                int e = 1; //arr[end]와 중복되는 값이 몇개인가?
                int cur = a[i] + a[start] + a[end];
                if (cur == 0) {
                    /* 고려해야할 사항 두가지
                     * #1. start ~ end까지 같은 수가 나열 (-4 2 2 2 2)
                     * #2. 각각 start와 end에서 같은 수가 나열 ( -5 -3 -3 0 8 8 )
                     */
                    if (a[start] == a[end]) {
                        //몇개가 중복되었는지 구하고 n개중에서 2개를 고르는 경우의 수가 필요 -> nC2
                        ans += comb(end - start + 1);
                        break;
                    }
                    // start값이 몇개 중복되었는지 계산
                    while (start + 1 < end && a[start] == a[start + 1]) {
                        s++;
                        start++;
                    }
                    // end값이 몇개 중복됐는지 계산
                    while (start < end - 1 && a[end] == a[end - 1]) {
                        e++;
                        end--;
                    }
                    //이동 다 했으니까 중복 경우의 수를 계산해서 넣어줌
                    ans += s * e;
                }
                if (cur > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(ans);

        br.close();
    }

    static int comb(int n) {
        return n * (n - 1) / 2;
    }

}
