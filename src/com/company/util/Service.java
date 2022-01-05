package com.company.util;

import com.company.model.Number;
import com.company.model.TypeNumber;

import java.util.Map;

import java.util.TreeMap;

public class Service {
    public static TreeMap<Integer, String> numberPut() {
        TreeMap<Integer, String> result = new TreeMap<>();
        result.put(1, "I");
        result.put(2, "II");
        result.put(3, "III");
        result.put(4, "IV");
        result.put(5, "V");
        result.put(6, "VI");
        result.put(7, "VII");
        result.put(8, "VIII");
        result.put(9, "IX");
        result.put(10, "X");
        result.put(40, "XL");
        result.put(50, "L");
        result.put(90, "XC");
        result.put(100, "C");
        result.put(400, "CD");
        result.put(500, "D");
        result.put(900, "CM");
        result.put(1000, "M");

        return result;
    }

    static Number checkType(String charS) throws Exception {

        int value;
        TypeNumber type;

        try {
            value = Integer.parseInt(charS);
            type = TypeNumber.ARABIC;
        } catch (NumberFormatException e) {
            value = toArabicNumber(charS);
            type = TypeNumber.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception(" Используйте числа от 1 до 10 ");
        }

        return new Number(value, type);
    }

    static Number checkType(String charS, TypeNumber type) throws Exception {
        Number number = checkType(charS);
        if (number.getType() != type) {
            throw new Exception("Разные типы,используйте один тип");
        }

        return number;

    }

    private static int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry<Integer, String> entry : numberPut().entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String toRomanNumber(int number) {

        int i = numberPut().floorKey(number);
        if (number == i) {
            return numberPut().get(number);
        }
        return numberPut().get(i) + toRomanNumber(number - i);
    }

    static int toArabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception("Неверный римский символ");

            i++;
            if (i == roman.length()) {
                result += num;
            } else {
                int nextNum = letterToNumber(roman.charAt(i));
                if (nextNum > num) {
                    result += (nextNum - num);
                    i++;
                } else result += num;
            }
        }
        return result;
    }


}

