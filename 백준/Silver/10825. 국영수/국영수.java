import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Student{
    String name;
    int kor,eng,math;

    Student(String name,int kor,int eng,int math){
        this.name=name;
        this.kor=kor;
        this.eng=eng;
        this.math=math;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Student>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String name=st.nextToken();
            int kor=Integer.parseInt(st.nextToken());
            int eng=Integer.parseInt(st.nextToken());
            int math=Integer.parseInt(st.nextToken());

            // 리스트에 학생 객체 생성해서 집어넣기
            list.add(new Student(name,kor,eng,math));
        }
        Collections.sort(list,(s1,s2)->{
            // 국어 점수 내림차순
            if(s1.kor!=s2.kor){
                return s2.kor-s1.kor;
            }
            // 영어 점수 오름차순
            if(s1.eng!=s2.eng){
                return s1.eng-s2.eng;
            }
            // 수학 점수 내림차순
            if(s1.math!=s2.math){
                return s2.math-s1.math;
            }
            // 이름 사전 순
            return s1.name.compareTo(s2.name);
        });

        StringBuilder sb=new StringBuilder();
        for(Student s:list){
            sb.append(s.name).append("\n");
        }
        System.out.print(sb);
    }
}