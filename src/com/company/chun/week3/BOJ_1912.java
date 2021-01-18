public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = a[i];
            if (d[i - 1] + a[i] > d[i])
                d[i] = d[i - 1] + a[i];
        }
        
        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i])
                ans = d[i];
        }
        System.out.println(ans);
    }
}