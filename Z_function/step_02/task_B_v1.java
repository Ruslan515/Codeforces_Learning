//B. Z-функция строки Грея
package z_func.step_02;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task_B_v1 {
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
//        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ans = new int[t];
        int[] list_k = new int[t];
        int[] list_j = new int[t];
        Map<Integer, String> my_dict = new HashMap<Integer, String>();
        int k, j;
        for (int tt = 0; tt < t; tt++) {
            k = sc.nextInt();
            j = sc.nextInt();
            list_k[tt] = k;
            list_j[tt] = j;
            if (!my_dict.containsKey(k)) {
                String g = "a";
                char c = 'b';
                for(int kk = 1; kk < k; kk++) {
                    g = g + c + g;
                    c += 1;
                }
                my_dict.put(k, g);
            }
        }

        for (int tt = 0; tt < t; tt++) {
            k = list_k[tt];
            j = list_j[tt];
//        int[] z = new int[n];
//        z[0] = 0;
//        System.out.print(z[0]);
//            System.out.print(0);
//            System.out.print(" ");
            if (j == 0)
                ans[tt] = 0;
//                System.out.println(j);
            else {
                String g = my_dict.get(k);
                int n = g.length();
                int i = j;
                int jj = 0;
                while ((i + jj) < n && g.charAt(jj) == g.charAt(i + jj))
                    jj++;
//            z[i] = jj;
//                System.out.println(jj);
                ans[tt] = jj;
            }
        }

        for (int tt = 0; tt < t; tt++){
            System.out.println(ans[tt]);
        }
    }

}
