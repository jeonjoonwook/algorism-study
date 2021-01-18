//DP를 사용해 해결
//Time Complex: O(n)
public class Main {
    private final static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N + 1];
        if (N == 1) {
            System.out.println(1);
            return;
        }
        if (N == 2) {
            System.out.println(2);
            return;
        }
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= N; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % MOD;
        }

        System.out.println(memo[N]);
    }
}