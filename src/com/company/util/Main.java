package com.company.util;

import com.company.model.Number;
import com.company.model.TypeNumber;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Введите значение через пробелы! ");

        while (true) {

            System.out.println("\nВведите: ");
            String line = scanner.nextLine();

            if (line.equals("e")) {
                System.out.println("Пока!");
                break;
            }
            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Неправильно ввел, попробуйте еще раз");

                Number firstNumber = Service.checkType(symbols[0]);
                Number secondNumber = Service.checkType(symbols[2], firstNumber.getType());
                String result = calculate(firstNumber, secondNumber, symbols[1]);
                System.out.print(  result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static String calculate(Number first, Number second, String action) throws Exception {

        int result;

        switch (action) {
            case "+":
                result = first.getValue() + second.getValue();
                break;
            case "-":
                result = first.getValue() - second.getValue();
                break;
            case "*":
                result = first.getValue() * second.getValue();
                break;
            case "/":
                result = first.getValue() / second.getValue();
                break;
            default:
                throw new Exception(" Используйте только +, -, *, /");
        }

        if (first.getType() == TypeNumber.ROMAN) {
            return Service.toRomanNumber(result);
        } else return String.valueOf(result);
    }
}
