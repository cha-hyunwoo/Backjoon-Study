import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 뒤에 껄로 정렬하고 다음 회의는 앞에꺼 숫자가 가장 작은거중에 앞의 회의 끝나는시간 이상인거 찾아서 회의개수 추가
        int n = Integer.parseInt(br.readLine()); // 회의의 수

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i][0] = start;
            meetings[i][1] = end;
        }
        // 람다식으로 (2,2) (1,2) 이런 예외를 막아줌
        Arrays.sort(meetings,(o1,o2)->{
            if(o1[1]==o2[1]){ // 종료 시간이 같으면
                return o1[0]-o2[0]; // 시작 시간 기준 오름차순
            }
            return o1[1]-o2[1];
        });

        int count = 0; // 가능한 회의의 수 카운트
        int preEnd = 0; // 회의 끝난 시간 저장할 변수

        for (int i = 0; i < n; i++) {
            // 이 미팅의 끝나는 시간이 현재 시간 이상인지 확인
            if (meetings[i][0] >= preEnd) {
                count++;
                // 이 회의 끝나는 기준으로 업데이트
                preEnd = meetings[i][1];
            }
        }
        System.out.print(count);
    }
}
