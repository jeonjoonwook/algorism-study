import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int dp[] = new int[1001];
        //미리 설정
		dp[1] = 1;
		dp[2] = 2;
        
        //입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        
		for (int i = 3; i <= n; i++) {
            //점화식
			dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
