import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cro = br.readLine();

        int count = 0; // 크로티아 알파벳 개수
        for (int i = 0; i < cro.length(); i++) {
            char cur = cro.charAt(i);

            switch (cur) {
                case 'c':
                    if (i < cro.length() - 1) {
                        if (cro.charAt(i + 1) == '=' || cro.charAt(i + 1) == '-') {
                            i++;

                        }
                    }
                    break;
                case 'd':
                    if (i < cro.length() - 1) {
                        if (cro.charAt(i + 1) == '-') {
                            i++;

                        } else if (cro.charAt(i + 1) == 'z' && i < cro.length() - 2) {
                            if (cro.charAt(i + 2) == '=') {
                                i+=2;
                            }
                        }
                    }
                    break;
                case 'l':
                case 'n':
                    if (i < cro.length() - 1) {
                        if (cro.charAt(i + 1) == 'j') {
                            i++;
                        }
                    }
                    break;
                case 's':
                case 'z':
                    if (i < cro.length() - 1) {
                        if (cro.charAt(i + 1) == '=') {
                            i++;
                        }
                    }
                    break;
            }
            count++;
        }
        System.out.print(count);
    }
}