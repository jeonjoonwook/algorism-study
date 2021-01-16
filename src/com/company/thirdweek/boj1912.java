import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int max = -1000;
		int i = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		
		int input[] = new int[loop];
		int subTotal[] = new int[loop];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
        //입력
		for(i = 0; i < loop; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		subTotal[0] = input[0];
		
        
		for (i = 1; i < loop; i++) {
            //점화식
			subTotal[i] = Math.max(subTotal[i - 1] + input[i], input[i]);
            //연속합배열과 저장된 최대값 중 큰 값으로 최대값 갱신
			max = Math.max(max, subTotal[i]);
		}
        
		max = Math.max(max, subTotal[0]);
		System.out.println(max);
	}
}
