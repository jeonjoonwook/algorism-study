import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder("#");
        for(int i = 0 ; i <s.length() ; i++){
            sb.append(s.charAt(i)).append("#");
        }
        br.close();
        System.out.println(palindrome(sb.toString()));
    }
    static public int palindrome(String s) {
        int[] memo = new int[s.length()];
        int max = 1;
        int r = 0, p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i <= r)
                memo[i] = Math.min(memo[2 * p - i], r - i);
            else
                memo[i] = 0;

            while (i - memo[i] - 1 >= 0 && i + memo[i] + 1 < s.length()
                    && s.charAt(i - memo[i] - 1) == s.charAt(i + memo[i] + 1))
                memo[i]++;

            max = Math.max(max, memo[i]);
            if (r < i + memo[i]) {
                r = i + memo[i];
                p = i;
            }
        }
        return max;
    }
}