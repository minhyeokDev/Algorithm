import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int lang = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, lang, english, math));
        }
        Collections.sort(students, (o1, o2) -> {
            if (o1.lang == o2.lang) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english; // 증가 순
            }
            return o2.lang - o1.lang;
        });

        for (int i = 0; i < n; i++) {
            sb.append(students.get(i).name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static class Student {

        String name;
        int lang, english, math;

        public Student(String name, int lang, int english, int math) {
            this.name = name;
            this.lang = lang;
            this.english = english;
            this.math = math;
        }
    }

}
