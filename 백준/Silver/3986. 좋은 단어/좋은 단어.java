import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if (stack.empty()) {
					stack.push(c);
				} else {
					if (c == 'A') {
						if (stack.peek() == 'A') {
							stack.pop();
						} else {
							stack.push(c);
						}
					} else if (c == 'B') {
						if (stack.peek() == 'B') {
							stack.pop();
						} else {
							stack.push(c);
						}
					}
				}
			}
			if (stack.empty()) {
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();

	}

}
