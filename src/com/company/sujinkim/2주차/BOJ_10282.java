import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<int[]> list[] = new ArrayList[n+1];
            for(int i = 1; i <= n; i++){
                list[i] = new ArrayList<int[]>();
            }
            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[b].add(new int[] {a, s});
            }
            
            PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){        
                @Override
                public int compare(int[] o1, int[] o2){
                    return o1[1] - o2[1];
                }
            });
            
            int[] path = new int[n+1];
            Arrays.fill(path, Integer.MAX_VALUE);
            path[c] = 0;
            q.offer(new int[] {c, 0});
            
            while(!q.isEmpty()){
                int[] now = q.poll();
                int nowNum = now[0];
                int nowVal = now[1];
                
                for(int i = 0; i < list[nowNum].size(); i++){
                    int[] next = list[nowNum].get(i);
                    int nextNum = next[0];
                    int nextVal = next[1];
                    if(path[nextNum] > nowVal + nextVal){
                        path[nextNum] = nowVal + nextVal;
                        q.offer(new int[] {nextNum, path[nextNum]});
                    }
                }
            }
            
            int ans1 = 0;
            int ans2 = 0;
            for(int i = 1; i <= n; i++){
                if(path[i] != Integer.MAX_VALUE)
                    ans1 ++;
                if(path[i] != Integer.MAX_VALUE && ans2 < path[i])
                    ans2 = path[i];
            }
            
            System.out.println(ans1 + " " + ans2);
        }
    }
}