public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        } else if (N < 4) {
            System.out.println(1);
            return;
        }

        memo = new int[N + 1];
        Arrays.fill(memo, 100001);
        memo[2] = 1;
        memo[3] = 1;
        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0) {
                memo[i] = memo[i / 3] + 1;
            }
            if (i % 2 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }
            memo[i] = Math.min(memo[i], memo[i - 1] + 1);
        }
        System.out.println(memo[N]);
    }
}