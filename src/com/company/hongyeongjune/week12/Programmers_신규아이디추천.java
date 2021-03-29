package com.company.hongyeongjune.week12;

public class Solution {
    public String solution(String new_id) {

        // 첫번째
        String one = new_id.toLowerCase();

        // 두번째
        StringBuilder two = new StringBuilder();
        for (char c : one.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c == '-' || c == '_' || c == '.')) {
                two.append(c);
            }
        }

        // 세번째
        String three = two.toString().replace("..", ".");
        while (three.contains("..")) {
            three = three.replace("..", ".");
        }

        // 네번째
        String four = three;
        if (three.charAt(0) == '.') {
            four = three.replaceFirst(".", "");
        }
        if (!four.equals("") && four.charAt(four.length() - 1) == '.') {
            four = four.substring(0, four.length() - 1);
        }

        // 다섯번째
        String five = four;
        if (four.equals("")) five = "a";

        // 여섯번째
        String six = five;
        if (five.length() >= 16) {
            six = five.substring(0, 15);
            if (six.charAt(six.length() - 1) == '.') {
                six = six.substring(0, six.length() - 1);
            }
        }

        // 일곱번째
        StringBuilder seven = new StringBuilder(six);
        if (seven.toString().length() <= 2) {
            while (seven.toString().length() < 3) {
                seven.append(seven.toString().charAt(seven.toString().length() - 1));
            }
        }

        return seven.toString();
    }
}
