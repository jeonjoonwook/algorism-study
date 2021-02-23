import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nmk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmk[0]);

        int m = Integer.parseInt(nmk[1]);

        int k = Integer.parseInt(nmk[2]);

        int[][] track = new int[k][3];

        for (int i = 0; i < k; i++) {
            String[] trackRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int trackItem = Integer.parseInt(trackRowItems[j]);
                track[i][j] = trackItem;
            }
        }

        if(k == 0){
            bufferedWriter.write(BigInteger.valueOf(n * m).toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            scanner.close();
            return;
        }
        List<Pair> tmp = new LinkedList<>();
        for (int[] arr : track) {
            tmp.add(new Pair(arr[0], arr[1], arr[2]));
        }

        tmp.sort(Comparator.comparingInt(Pair::getRow)
                .thenComparing(Pair::getStart));

        List<Pair> list = new LinkedList<>();
        int idx = 1, row = tmp.get(0).row, start = tmp.get(0).start, end = tmp.get(0).end;
        while (idx < tmp.size()) {
            if (tmp.get(idx).row != row) {
                list.add(new Pair(row, start, end));
                row = tmp.get(idx).row;
                start = tmp.get(idx).start;
                end = tmp.get(idx).end;
                idx++;
                continue;
            }
            if(tmp.get(idx).start <= end){
                end = Math.max(end, tmp.get(idx).end);
            }else{
                list.add(new Pair(row, start, end));
                start = tmp.get(idx).start;
                end = tmp.get(idx).end;
            }
            idx++;
        }
        list.add(new Pair(row, start, end));

        BigInteger bigInteger = BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
        for (Pair pair : list) {
            bigInteger = bigInteger.subtract(BigInteger.valueOf(pair.end - pair.start + 1));
        }
        bufferedWriter.write(bigInteger.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class Pair {
        int row, start, end;

        public Pair(int row, int start, int end) {
            this.row = row;
            this.start = start;
            this.end = end;
        }

        public int getRow() {
            return row;
        }

        public int getStart() {
            return start;
        }
    }
}
