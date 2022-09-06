//A. Z-функция (простая версия)
// https://codeforces.com/edu/course/2/lesson/3/3/practice/contest/272263/problem/A
package z_func.step_03;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

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
        String s = sc.nextString((int) Math.pow(10, 6));
        int n = s.length();
        int[] z = new int[n];
        int l = 0;
        int r = 0;
        System.out.print(z[0] + " ");
        for (int i = 1; i < n; i++) {
            if (r >= i)
                z[i] = Math.min(z[i - l], r - i + 1);
            while (z[i] + i < n && s.charAt(z[i]) == s.charAt(z[i] + i))
                z[i]++;
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            System.out.print(z[i] + " ");
        }
//        System.out.println();
//        System.out.println(Arrays.toString(z));

    }

}
