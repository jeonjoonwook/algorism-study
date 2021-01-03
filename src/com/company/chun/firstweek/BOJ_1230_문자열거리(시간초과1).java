import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static String src, dest;
    private final static int MAX_VAL = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        src = br.readLine();
        dest = br.readLine();
        if(src.length() > dest.length()){
            System.out.println(-1);
            return;
        }

        int answer = MAX_VAL;
        if(src.charAt(0) == dest.charAt(0))
            answer = solution(0, 0);
        for(int i = 0 ; i < dest.length() ; i++){
            if(src.charAt(0) != dest.charAt(i))
                continue;
            answer = Math.min(answer, solution(0, i) + 1);
        }

        if(answer >= MAX_VAL)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    // srcIdx의 문자가 destIdx의 문자일 때 삽입 횟수.
    // 삽입을 해도 못만들어지면 Integer.MAX 를 리턴
    private static int solution(int srcIdx, int destIdx){
        // 첫번째로 srcIDX의 문자와 destIDX의 문자는 같음
        // 최대한 길게 맞춘다음, 안맞는 문자를 탐색한다.
        while(srcIdx < src.length() && destIdx < dest.length()
                && src.charAt(srcIdx) == dest.charAt(destIdx)){
            srcIdx++; destIdx++;
        }


        if(srcIdx == src.length())
            return destIdx == dest.length() ? 0 : 1;
        if(destIdx == dest.length())
            return MAX_VAL;

        int answer = MAX_VAL;
        for(int k = destIdx ; k < dest.length() ; k++){
            if(dest.charAt(k) != src.charAt(srcIdx))
                continue;
            answer = Math.min(answer, solution(srcIdx, k) + 1);
        }
        return answer;
    }
}