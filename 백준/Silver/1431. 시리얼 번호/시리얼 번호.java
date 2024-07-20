import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}


		Arrays.sort(arr, (e1, e2) -> {
			if (e1.length() != e2.length()) {
				return e1.length() - e2.length();
			} else if (e1.length() == e2.length()) {
				int sum1 = 0;
				int sum2 = 0;

				for (int i = 0; i < e1.length(); i++) {
					if (e1.charAt(i) <= '9' && e1.charAt(i) >= '0') {
						sum1 += Integer.parseInt(String.valueOf(e1.charAt(i)));
					}
				}
				for (int i = 0; i < e2.length(); i++) {
					if (e2.charAt(i) <= '9' && e2.charAt(i) >= '0') {
						sum2 += Integer.parseInt(String.valueOf(e2.charAt(i)));
					}
				}
				if (sum1 == sum2) {
					return e1.compareTo(e2);
				} else {
					return sum1 - sum2;
				}
			} else {
				return e1.compareTo(e2);
			}
		});

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}


	}

}
