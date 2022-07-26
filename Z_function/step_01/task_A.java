/*
https://codeforces.com/edu/course/2/lesson/3/1/practice/contest/272260/problem/A
 */
package z_func.step_01;

import java.io.DataInputStream;
import java.io.InputStream;

public class task_A {
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
        for (int i = 0; i < t; i++) {
            s = sc.nextString(2000);
            int n = s.length();
            for (int j = n - 1; j >= 0; j--) {
                int k = 0;
                int j_half = (j + 1) / 2;
                while (k < j_half && s.charAt(k) == s.charAt(j - k)) {
                    k++;
                }
                if (k == j_half) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}