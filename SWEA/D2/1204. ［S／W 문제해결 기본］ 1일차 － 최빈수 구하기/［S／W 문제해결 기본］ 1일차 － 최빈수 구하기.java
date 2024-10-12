import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append("#").append(n).append(" ");
			int[] arr = new int[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int key = Integer.parseInt(st.nextToken());
				arr[key]++;
			}
			
			int max =0;
			int index = 0;
			for (int i = 0; i <= 100; i++) {
				if(arr[i] >= max) {
					max = arr[i];
					index = i;
				}
			}
			
			
			sb.append(index).append("\n");
		}
		System.out.println(sb);
		
	}

}
