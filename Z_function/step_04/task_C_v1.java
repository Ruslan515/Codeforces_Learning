// C. Вхождения префиксов
// https://codeforces.com/edu/course/2/lesson/3/4/practice/contest/272262/problem/C
package z_func.step_04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class task_C_v1 {

    public static void solving(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0;
        int r = 0;
        int[] temp = new int[n + 1];
        Arrays.fill(temp, 1);
        for (int i = 1; i < n; i++) {
            if (r >= i) {
                z[i] = Math.min(z[i - l], r - i + 1);
                for (int step = 1; step <= z[i]; step++) {
                    temp[step]++;
                }

            }

            while (z[i] + i < n && s.charAt(z[i]) == s.charAt(z[i] + i)) {
                z[i]++;
                temp[z[i]]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        for (int i = 1; i < n + 1; i++)
            System.out.print(temp[i] + " ");
//        System.out.println(Arrays.toString(temp));

        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String s = sc.nextLine();
        String t = "";
        for (int qq = 0; qq < q; qq++) {
            s = sc.nextLine();
            solving(s);
            System.out.println();
        }

    }

}
