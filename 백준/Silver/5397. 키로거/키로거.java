import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			Stack<Character> keyStack = new Stack<>();
			Stack<Character> deleteStack = new Stack<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char pos = s.charAt(j);
				if (pos == '<') {
					if (!keyStack.empty()) {
						deleteStack.push(keyStack.pop());
					}
				} else if (pos == '>') {
					if (!deleteStack.empty()) {
						keyStack.push(deleteStack.pop());
					}
				} else if (pos == '-') {
					if (!keyStack.empty()) {
						keyStack.pop();
					}
				} else {
					keyStack.push(pos);
				}
			}
			while (!deleteStack.empty()) {
				keyStack.push(deleteStack.pop());
			}
			for (int j = 0; j < keyStack.size(); j++) {
				bw.write(keyStack.get(j));
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
