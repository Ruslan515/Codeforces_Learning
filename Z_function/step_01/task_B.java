/*
https://codeforces.com/edu/course/2/lesson/3/1/practice/contest/272260/problem/B
 */
package z_func.step_01;

import java.io.DataInputStream;
import java.io.InputStream;

public class task_B {
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
        String s;
        for (int tt = 0; tt < t; tt++) {
            s = sc.nextString(500);
            int n = s.length();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    String sub_str = s.substring(i, j + 1);
                    int n_sub_str = j - i + 1;
                    String prefix = s.substring(0, n_sub_str);
                    String suffix = s.substring(n - n_sub_str, n);
                    if (sub_str.equals(prefix) ^ sub_str.equals(suffix)) {
                        count++;
                    }

                }
            }

            System.out.println(count);
        }
    }
}