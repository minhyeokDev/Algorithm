import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (st.hasMoreTokens()) {
				int x = Integer.parseInt(st.nextToken());
				if (command.equals("push")) {
					s.push(x);
				}
			}
			 else if (command.equals("pop")) {
				if (!s.empty()) {
					bw.write(s.pop().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			} else if (command.equals("size")) {
				bw.write(s.size() + "\n");
			} else if (command.equals("empty")) {
				if (s.empty()) {
					bw.write("1" + "\n");
				} else {
					bw.write("0" + "\n");
				}
			} else if (command.equals("top")) {
				if (!s.empty()) {
					bw.write(s.peek().toString() + "\n");
				} else {
					bw.write("-1" + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();

	}
}
