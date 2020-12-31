import java.util.Scanner;

public class boj2798_blackjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cardLength = sc.nextInt();
        int maxLimit = sc.nextInt();

        int[] cards = new int[cardLength];

        for (int i = 0; i < cardLength; i++) {
            cards[i] = sc.nextInt();
        }

        int max = 0;
        int sumTemp;

        //brute force
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    // System.out.println("%d, %d, %d", i, j, k);
                    sumTemp = cards[i] + cards[j] + cards[k];
                    if (sumTemp <= maxLimit && max < sumTemp) {
                        max = sumTemp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
