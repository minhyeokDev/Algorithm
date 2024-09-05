import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] a;
    static int[] two;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        two = new int[(a.length * (a.length + 1)) / 2];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) { // 중복 최소화 하기 위해 j=i부터
                two[count++] = a[i] + a[j];
            }
        }

        Arrays.sort(two);
        int answer = -1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int target = a[i] - a[j];
//                //binarySearch 직접 구현 방식
//                if (binarySearch(a[i] - a[j])) {
//                    answer = Math.max(answer, a[i]);
//                }
                if (Arrays.binarySearch(two, target) > -1) {
                    answer = Math.max(answer, a[i]);
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

//    public static boolean binarySearch(int target) {
//        int st = 0;
//        int en = two.length - 1;
//        while (st <= en) {
//            int mid = (st + en) / 2;
//            if (two[mid] < target) {
//                st = mid + 1;
//            } else if (two[mid] > target) {
//                en = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

}
