import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int m=Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트의 주소의 수

        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            String address=st.nextToken(); // 주소
            String password=st.nextToken(); // 비번
            map.put(address,password);
        }
        for(int i=0;i<m;i++){
            String findAddress=br.readLine();
            sb.append(map.get(findAddress)).append("\n");
        }
        System.out.print(sb);
    }
}