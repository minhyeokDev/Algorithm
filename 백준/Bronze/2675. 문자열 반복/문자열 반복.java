import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        StringBuilder sb;
        String test1;
        String test2;

        String[] strings = new String[test];
        for (int i = 0; i < test; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < a; k++) {
                    sb.append(s.charAt(j));
                }
            }
            strings[i] = sb.toString();

        }

        for (int i = 0; i < test; i++) {
            System.out.println(strings[i]);
        }
    }
}
