import java.util.Scanner;

public class boj2920_music {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[8];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        String result = "";
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] < input[i + 1]) {
                if (result.equals("descending")) {
                    result = "mixed";
                    break;
                }
                result = "ascending";
            } else if (input[i] > input[i + 1]) {
                if (result.equals("ascending")) {
                    result = "mixed";
                    break;
                }
                result = "descending";
            }
        }
    }
}
