import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, N;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            int[] y = new int[N+2];
            int[] x = new int[N+2];
            for(int i = 0 ; i < y.length ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            distance = new int[y.length][x.length];
            for(int r = 0 ; r < distance.length ; r++){
                for(int c = r+1 ; c < distance[0].length ; c++){
                    if (r == c)
                        continue;
                    int d = Math.abs(y[r] - y[c]) + Math.abs(x[r] - x[c]);
                    distance[r][c] = d;
                    distance[c][r] = d;
                }
            }

            String answer = "sad";
            boolean[] visited = new boolean[distance.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            visited[0] = true;
            while(!queue.isEmpty()){
                int poll = queue.poll();
                if(poll == distance.length-1){
                    answer = "happy";
                    break;
                }

                for(int i = 0 ; i < distance.length ; i++){
                    if(poll != i && !visited[i] && distance[poll][i] <= 1000){
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}