package com.ollierupprecht.dsa.leetcode;

import java.util.LinkedList;

public class DecimalToBinary {
    public int decimalRep;

    public DecimalToBinary(int decimalRep) {
        this.decimalRep = decimalRep;
    }

    public String converter() {
        if (decimalRep <= 0) return "No num";
        int temp = decimalRep;
        LinkedList list = new LinkedList();
        StringBuilder string = new StringBuilder();

        while (temp > 0) {
            list.addFirst(temp%2);
            temp = temp / 2;
        }

        for (int i = 0; i < list.size(); i++) {
            string.append(list.get(i));
        }

        return string.toString();
    }
}
