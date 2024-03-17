import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		StringBuilder sb = new StringBuilder();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			list.add(Character.getNumericValue(s.charAt(i)));
		}

		Collections.sort(list, Collections.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}

		System.out.println(sb);


	}

}
