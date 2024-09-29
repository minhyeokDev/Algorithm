import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static char[] arr;
    static char[] code;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        code = new char[L];

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        func(0, 0);
        System.out.println(sb);

        br.close();
    }

    public static void func(int k, int start) {
        if (k == L) {
            if (check()) {
                sb.append(code).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[k] = arr[i];
            func(k + 1, i + 1);
        }
    }

    // 모음 체크 함수
    public static boolean isValid(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static boolean check() {
        int vowels = 0;
        int consonants = 0;

        for (char x : code) {
            if (isValid(x)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        // 모음이 1개 이상이고 자음이 2개 이상일 때 true
        return vowels >= 1 && consonants >= 2;
    }

}
