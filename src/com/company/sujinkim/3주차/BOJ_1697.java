import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //수빈이 위치
		int k = Integer.parseInt(st.nextToken()); //동생 위치
		
		if(n >= k) { //예외처리
			System.out.println(n - k);
		}else {
			bfs(n, k);
		}
    }
    
    private static void bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        int[] check = new int[100001]; //방문여부를 체크하는 배열. 수빈이와 동생이 위치할 수 있는 범위는 0~100,000
        
        q.add(n);
        check[n] = 1;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            
            //이동할 수 있는 경우 세가지에 대하여 모두 계산
            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0){
                    next = temp + 1;
                }else if(i == 1){
                    next = temp - 1;
                }else{
                    next = temp * 2;
                }
                
                if(next == k){
                    System.out.println(check[temp]);
                    return;
                }
                if(next >= 0 && next < check.length && check[next] == 0){
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}