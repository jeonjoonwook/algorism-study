public class Main {
    private static int[] arr, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }
        memo[0] = arr[0];
        memo[1] = arr[0] + arr[1];

        for (int i = 2; i < N; i++) {
            int v1 = arr[i] + memo[i - 1];
            int v2 = arr[i] + arr[i - 1];
            memo[i] = Math.min(v1 + memo[i - 1], v2 + (v2 + memo[i - 2]));
        }

        System.out.println(memo[N-1]);
    }
}