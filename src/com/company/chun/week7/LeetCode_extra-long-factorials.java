class Solution {
    static void extraLongFactorials(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);
        for(int i = n-1 ; i >0 ; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigInteger.toString());
    }
}