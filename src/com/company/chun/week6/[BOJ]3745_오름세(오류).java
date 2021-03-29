import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연속되게 오름순인줄 알았습니다.
public class Main {
    static int N;
    static int[] arr;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        while(sc.hasNext()){
            N = sc.nextInt();
            arr = new int[N];
            memo = new int[N];

            for(int i = 0 ; i < N ; i++){
                arr[i] = sc.nextInt();
            }
            int answer = 1;
            memo[0] = 1;
            for(int i = 1 ; i < N ; i++){
                if(arr[i] > arr[i-1]){
                    memo[i] = memo[i-1] + 1;
                }else{
                    memo[i] = 1;
                }

                answer = Math.max(answer, memo[i]);
            }
            System.out.println(answer);
        }
    }
}