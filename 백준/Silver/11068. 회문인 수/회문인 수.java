import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int res = 0;
            int num = Integer.parseInt(br.readLine());
            for (int b = 2; b <= 64; b++) {
                if (res == 1) {
                    break;
                }
                int n = num;
                int len = 0;
                int[] resArr = new int[20];
                // 진법 변환
                while (n != 0) {
                    resArr[len++] = n % b;
                    n = n / b;
                }
                // 회문 판별
                for (int i = 0; i <= len / 2; i++) {
                    if (resArr[i] == resArr[len - 1 - i]) {
                        if(i == len/2)
                            res = 1;
                    } else
                        break;
                }

            }
            System.out.println(res);
        }


    }

}
