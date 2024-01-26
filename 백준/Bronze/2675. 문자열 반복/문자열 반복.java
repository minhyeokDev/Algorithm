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

        String[] strings = new String[test];
        for (int i = 0; i < test; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < R; k++) {
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