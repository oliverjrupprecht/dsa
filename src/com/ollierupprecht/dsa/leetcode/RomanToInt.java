package com.ollierupprecht.dsa.leetcode;

public class RomanToInt {
    public static int romanToInt(String s) {
        char[] string = s.toCharArray();
        int i = 0;
        int value = 0;

        while (i < string.length) {
            switch (string[i]) {
                case 'I':
                    if (i + 1 < string.length && string[i + 1] == 'V') {
                        value += 4;
                        i++;
                    } else if (i + 1 < string.length && string[i + 1] == 'X') {
                        value += 9;
                        i++;
                    } else {
                        value += 1;
                    }
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    if (i + 1 < string.length && string[i + 1] == 'L') {
                        value += 40;
                        i++;
                    } else if (i + 1 < string.length && string[i + 1] == 'C') {
                        value += 90;
                        i++;
                    } else {
                        value += 10;
                    }
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'C':
                    if (i + 1 < string.length && string[i + 1] == 'D') {
                        value += 400;
                        i++;
                    } else if (i + 1 < string.length && string[i + 1] == 'M') {
                        value += 900;
                        i++;
                    } else {
                        value += 100;
                    }
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'M':
                    value += 1000;
                    break;
            }
            i++;
        }
        return value;
    }
}
