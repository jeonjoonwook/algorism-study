import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N;
    static boolean[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            visited = new boolean[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = true;
            }
            int answer = 0;
            for(int r = 0 ; r < N ; r++){
                for(int c = 0 ; c < M ; c++){
                    if(!visited[r][c] && map[r][c]){
                        bfs(r, c);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < dy.length; i++) {
                int y = poll.r + dy[i];
                int x = poll.c + dx[i];
                if(check(y, x)){
                    visited[y][x] = true;
                    queue.offer(new Node(y, x));
                }
            }
        }
    }

    private static boolean check(int y, int x) {
        return y >= 0 && y < N
                && x >= 0 && x < M
                && map[y][x]
                && !visited[y][x];
    }

    static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}