// C. Строка по z-функции
// https://codeforces.com/edu/course/2/lesson/3/2/practice/contest/272261/problem/C
package z_func.step_02;

import java.io.DataInputStream;
import java.io.InputStream;

public class task_C_v1 {
    /*
    Нашел данный класс для ускорения ввода и вывода
     */
    private static class Parser {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Parser(InputStream in) {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead =  0;
        }
        public String nextString(int maxSize) {
            byte[] ch = new byte[maxSize];
            int point =  0;
            try {
                byte c = read();
                while (c == ' ' || c == '\n' || c=='\r')
                    c = read();
                while (c != ' ' && c != '\n' && c!='\r') {
                    ch[point++] = c;
                    c = read();
                }
            } catch (Exception e) {}
            return new String(ch, 0,point);
        }
        public int nextInt() {
            int ret =  0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {}
            return ret;
        }
        public long nextLong() {
            long ret =  0;
            boolean neg;
            try {
                byte c = read();
                while (c <= ' ')
                    c = read();
                neg = c == '-';
                if (neg)
                    c = read();
                do {
                    ret = ret * 10 + c - '0';
                    c = read();
                } while (c > ' ');

                if (neg) return -ret;
            } catch (Exception e) {}
            return ret;
        }
        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer =  0, BUFFER_SIZE);
            } catch (Exception e) {}
            if (bytesRead == -1) buffer[ 0] = -1;
        }

        private byte read() {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static void main(String[] args) {
        Parser sc = new Parser(System.in);
        int t = sc.nextInt();
        int LEN_ALPH = 26;
        String[] ans = new String[t];
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int[] z = new int[n];
            String s = "";
            for (int i = 0; i < n; i++) {
                z[i] = sc.nextInt();
                if (z[i] + i > n || z[0] != 0) {
                    s = "!";
                    ans[tt] = s;
                    continue;
                }
            }
            if (ans[tt] == "!")
                continue;
            else {
                char current_char = 'a';
                int prefix_len = 0;
                int j = 0;
                int new_char = 0;
                for (int i = 0; i < n; i++) {
                    if (z[i] == 0 && prefix_len == 0) {
                        if (new_char < LEN_ALPH) {
                            s += current_char;
                            current_char++;
                            new_char++;
                        }
                        else {
                            char temp = current_char;
                            temp--;
                            s += temp;
                        }
                    }
                    if (z[i] > prefix_len) {
                        prefix_len = z[i];
                        j = 0;
                    }
                    if (prefix_len > 0) {
                        s += s.substring(j, j + 1);
                        j++;
                        prefix_len--;
                    }

                }

                ans[tt] = s;

            }

        }

        for (int tt = 0; tt < t; tt++)
            System.out.println(ans[tt]);

    }

}
