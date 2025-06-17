package com.ollierupprecht.dsa.leetcode;

import java.util.LinkedList;
import java.util.Objects;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (Objects.equals(t, "")) {
            return false;
        } else if (Objects.equals(s, "")){
            return true;
        } else if (Objects.equals(s, "0") && Objects.equals(t, "0")) return false;

        char[] target = s.toCharArray();
        char[] string = t.toCharArray();
        int j = 0;

        for (int i = 0; i < string.length; i++) {
            if (string[i] == target[j]) {
                j++;
            }
        }

        return j == target.length;
    }
}
