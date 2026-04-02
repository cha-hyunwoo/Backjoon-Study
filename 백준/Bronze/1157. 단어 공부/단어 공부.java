import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine().toUpperCase();

        int[]alphabet=new int[26];
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'A']++;
        }

        int max= -1;
        char result= '?';

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                result = (char) (i + 'A');
            } else if (alphabet[i] == max) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}