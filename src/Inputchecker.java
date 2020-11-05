package src;

import java.io.*;

public class Inputchecker {
    public static char getLetter() {
        char res = 'a';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            res = br.readLine().trim().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static int getNumber() {
        int res = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            res = Integer.parseInt(br.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
