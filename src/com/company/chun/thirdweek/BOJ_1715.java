import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(!queue.isEmpty()){
            int n1 = queue.poll();
            if(queue.isEmpty())
                break;
            int n2 = queue.poll();
            cnt += n1 + n2;
            queue.offer(n1+n2);
        }

        System.out.println(cnt);
    }
}