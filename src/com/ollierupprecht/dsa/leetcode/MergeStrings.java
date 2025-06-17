package com.ollierupprecht.dsa.leetcode;

public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        char[] one = word1.toCharArray();
        char[] two = word2.toCharArray();
        char[] outArray = new char[one.length + two.length];
        StringBuilder out = new StringBuilder();

        int countOne = 0; int countTwo = 0;

        if (one.length < two.length) {
            while (countOne < one.length) {
                outArray[countOne * 2] = one[countOne];
                countOne++;
            }

            while (countTwo < one.length) {
                outArray[countTwo * 2 + 1] = two[countTwo];
                countTwo++;
            }

            int over = countTwo;
            countTwo *= 2;

            while (over < two.length) {
                outArray[countTwo] = two[over];
                countTwo++;
                over++;
            }

        } else if (one.length > two.length) {
            while (countOne < two.length) {
                outArray[countOne * 2] = one[countOne];
                countOne++;
            }

            while (countTwo < two.length) {
                outArray[countTwo * 2 + 1] = two[countTwo];
                countTwo++;
            }

            int over = countOne;
            countOne *= 2;

            while (over < one.length) {
                outArray[countOne] = one[over];
                countOne++;
                over++;
            }

        } else {
            while (countOne < one.length) {
                outArray[countOne * 2] = one[countOne];
                countOne++;
            }

            while (countTwo < one.length) {
                outArray[countTwo * 2 + 1] = two[countTwo];
                countTwo++;
            }
        }

        for (char c : outArray) {
            out.append(c);
        }

        return out.toString();
    }
}
