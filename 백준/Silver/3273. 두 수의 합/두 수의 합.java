import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int count = 0;
		int left=0;
		int right= n-1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == x) {
				count++;
				left++;
				right--;
			} else if (sum < x) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(count);


	}

}
