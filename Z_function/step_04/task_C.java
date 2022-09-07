// C. Вхождения префиксов
// https://codeforces.com/edu/course/2/lesson/3/4/practice/contest/272262/problem/C
package z_func.step_04;

import java.util.Scanner;

public class task_C {

    public static void solving(String s, String t) {
        int size_t = t.length();
        int n = s.length();
        int[] z = new int[n];
        int l = 0;
        int r = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (r >= i)
                z[i] = Math.min(z[i - l], r - i + 1);
            while (z[i] + i < n && s.charAt(z[i]) == s.charAt(z[i] + i))
                z[i]++;
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            if (z[i] == size_t){
                c++;
            }
        }
        System.out.print(c + " ");

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String s = sc.nextLine();
        String t = "";
        for (int qq = 0; qq < q; qq++) {
            s = sc.nextLine();
            for (int i = 1; i < s.length(); i++) {
                t = s.substring(0, i);
                String new_s = t + '$' + s;
                solving(new_s, t);
            }
            System.out.println(1);
        }

    }

}
