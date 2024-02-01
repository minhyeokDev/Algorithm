import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> list = new LinkedList<>();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = list.listIterator();

        //맨 뒤 이동
        while (iter.hasNext()) {
            iter.next();
        }


        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if (c == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }

            } else if (c == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (c == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (c == 'P') {
                char t = command.charAt(2);
                iter.add(t);
            }
        }
        for (Character chr : list) {
            bw.write(chr);
        }
        bw.flush();
    }

}
