import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				arr[0] ++;
			} else if (s.charAt(i) == 'b') {
				arr[1] ++;
			} else if (s.charAt(i) == 'c') {
				arr[2] ++;
			} else if (s.charAt(i) == 'd') {
				arr[3] ++;
			} else if (s.charAt(i) == 'e') {
				arr[4] ++;
			} else if (s.charAt(i) == 'f') {
				arr[5] ++;
			} else if (s.charAt(i) == 'g') {
				arr[6] ++;
			} else if (s.charAt(i) == 'h') {
				arr[7] ++;
			} else if (s.charAt(i) == 'i') {
				arr[8] ++;
			} else if (s.charAt(i) == 'j') {
				arr[9] ++;
			} else if (s.charAt(i) == 'k') {
				arr[10] ++;
			} else if (s.charAt(i) == 'l') {
				arr[11] ++;
			} else if (s.charAt(i) == 'm') {
				arr[12] ++;
			} else if (s.charAt(i) == 'n') {
				arr[13] ++;
			} else if (s.charAt(i) == 'o') {
				arr[14] ++;
			} else if (s.charAt(i) == 'p') {
				arr[15] ++;
			} else if (s.charAt(i) == 'q') {
				arr[16] ++;
			} else if (s.charAt(i) == 'r') {
				arr[17] ++;
			} else if (s.charAt(i) == 's') {
				arr[18] ++;
			} else if (s.charAt(i) == 't') {
				arr[19] ++;
			} else if (s.charAt(i) == 'u') {
				arr[20] ++;
			} else if (s.charAt(i) == 'v') {
				arr[21] ++;
			} else if (s.charAt(i) == 'w') {
				arr[22] ++;
			} else if (s.charAt(i) == 'x') {
				arr[23] ++;
			} else if (s.charAt(i) == 'y') {
				arr[24] ++;
			} else if (s.charAt(i) == 'z') {
				arr[25] ++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
