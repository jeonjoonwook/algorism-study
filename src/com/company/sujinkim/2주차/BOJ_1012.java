import java.util.*;
import java.io.*;

public class Main{
    
    static int n, m, cnt;
	static boolean[][] arr;
	static boolean[][] chk;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int ans = 0;
			
			String[] temp = br.readLine().split(" ");
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			cnt = Integer.parseInt(temp[2]);
			
			arr = new boolean[n][m];
			chk = new boolean[n][m];
			
			for(int j = 0; j < cnt; j++) {
				temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				
				arr[x][y] = true; //배추O
			}
			for(int k = 0; k < n; k++) {
				for(int l = 0; l < m; l++) {
					if(arr[k][l] && !chk[k][l]) {
						ans ++;
						dfs(k, l);
					}
				}
			}
			System.out.println(ans);
		}
    }
    
	private static void dfs(int x, int y) {
        
        for(int i = 0; i < 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                continue;
            }
            if(chk[nextX][nextY] || !arr[nextX][nextY]){
                continue;
            }
            chk[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
        
	}
}