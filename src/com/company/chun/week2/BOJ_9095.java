public class Main {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            memo = new int[N + 1];
            memo[1] = 1;
            memo[2] = 2;
            memo[3] = 4;
            for (int i = 4; i <= N; i++) {
                memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
            }
            System.out.println(memo[N]);
        }
    }
}