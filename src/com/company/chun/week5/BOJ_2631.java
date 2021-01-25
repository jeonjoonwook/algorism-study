import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int maxLIS = 0;
        for(int i = 0 ; i < N ; i++){
            maxLIS = Math.max(maxLIS, lis(i));
        }
        System.out.println(N - maxLIS);
    }

    private static int lis(int idx){
        if(idx == N-1)
            return 1;
        if(memo[idx] != 0)
            return memo[idx];

        memo[idx] = 1;
        for(int i = idx+1 ; i<N ; i++){
            if(arr[i] < arr[idx])
                continue;
            memo[idx] = Math.max(memo[idx], lis(i) + 1);
        }
        return memo[idx];
    }
}