// A. Минимальный период строки
// https://codeforces.com/edu/course/2/lesson/3/4/practice/contest/272262/problem/A
package z_func.step_04;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class task_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String s = sc.nextLine();
        for (int tt = 0; tt < t; tt++) {
            s = sc.nextLine();
            int n = s.length();
            int[] z = new int[n];
            int l = 0;
            int r = 0;
            String answer = s;
            for (int i = 1; i < n; i++) {
                if (r >= i)
                    z[i] = Math.min(z[i - l], r - i + 1);
                while (z[i] + i < n && s.charAt(z[i]) == s.charAt(z[i] + i))
                    z[i]++;
                if (i + z[i] - 1 > r) {
                    l = i;
                    r = i + z[i] - 1;
                }
                if (z[i] + i == n){
                    answer = s.substring(0, i);
                    break;
                }
            }
            System.out.println(answer);
        }

    }

}
