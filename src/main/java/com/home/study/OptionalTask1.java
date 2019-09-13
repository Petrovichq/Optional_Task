package com.home.study;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) {
        final int n = 5;
        int counter = 0;

        Scanner scanner = new Scanner(System.in);
        String [] inputArray = new String[n];
        System.out.println("Insert " + n + " numbers:");
        for (int i = 0; i < n ; i++) {
            System.out.print(++counter + " = ");
            String inputNumber = scanner.nextLine();
            inputArray[i] = inputNumber;
        }

        String longestNegative = "";
        String longestPositive = "";
        String shortestPositive = "";
        String shortestNegative = "";
        for (String i:inputArray) {
            if (i.contains("-")){
                longestNegative = longestNegative.length() > (i.length() - 1) ? longestNegative : i;
                shortestNegative = shortestNegative.length() < (i.length() - 1) ? shortestNegative : i;
            }else{
                longestPositive = longestPositive.length() > i.length() ? longestPositive : i;
                shortestPositive = shortestPositive.length() < i.length() ? shortestPositive : i;
            }
        }
        String longestNumber = (longestNegative.length() - 1) > longestPositive.length() ? longestNegative : longestPositive;
        String shortestNumber = (shortestNegative.length() - 1) < shortestPositive.length() ? shortestNegative : shortestPositive;
        System.out.println("Number " + longestNumber + " have " + longestNumber.length()+ " symbol(s)");
        System.out.println("Number " + shortestNumber + " have " + shortestNumber.length() + " symbol(s)");  //1

        String temp;
        String[] arrayTemp = new String[inputArray.length];
        System.arraycopy(inputArray, 0,arrayTemp,0,inputArray.length);
        for (int j = 0; j < (n - 1); j++) {
            for (int i = 0; i < (n - 1); i++) {
                int lengthFirstNumber = arrayTemp[i].length();
                int lengthSecondNumber = arrayTemp[i + 1].length();
                if (arrayTemp[i].contains("-")){lengthFirstNumber -= 1;}
                if (arrayTemp[i + 1].contains("-")){lengthSecondNumber -= 1;}
                if (lengthFirstNumber < lengthSecondNumber){
                    temp = arrayTemp[i];
                    arrayTemp[i] = arrayTemp[i + 1];
                    arrayTemp[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayTemp));  //2

        int sum = 0;
        for (String s:inputArray) {
            sum = s.contains("-") ? sum + s.length() - 1 : sum + s.length();
        }
        int average = sum / n;
        System.out.print("Number with length less than average:");
        for (String s:inputArray) {
            if (s.length() < average) System.out.print(" " + s + "(" + s.length() + " symbol(s))");  //3
        }
        System.out.println();

        String simplestNumber = inputArray[0];
        int minAmountOfSymbols = (int) inputArray[0].chars().distinct().count();
        for (String value : inputArray) {
            int amountOfSymbols = (int) value.chars().distinct().count();
            if (value.contains("-")) {
                amountOfSymbols -= 1;
            }
            if (amountOfSymbols < minAmountOfSymbols) {
                minAmountOfSymbols = amountOfSymbols;
                simplestNumber = value;
            }
        }
        System.out.println("The simplest number is: " + simplestNumber);  //4

        int onlyEvenDigitsInNumber = 0;
        int equalEvenAndUneven = 0;
        for (String s:inputArray) {
            int evenDigits = 0;
            int unevenDigits = 0;
            for (int i = 0; i <s.length() ; i++) {
                if (s.charAt(i) == '-')continue;
                if (s.charAt(i) == '1' || s.charAt(i) == '3' || s.charAt(i) == '5' || s.charAt(i) == '7' || s.charAt(i) == '9'){
                    unevenDigits++;
                }else evenDigits++;
            }
            if (unevenDigits == 0){onlyEvenDigitsInNumber++;}
            if (evenDigits == unevenDigits){equalEvenAndUneven++;}
        }
        System.out.println("Amount of numbers with only even digits is: " + onlyEvenDigitsInNumber);
        System.out.println("Amount of numbers with equal even and uneven digits is: " + equalEvenAndUneven); //5

        String  increaseNumber = " have not.";
        for (String s : inputArray) {
            int validCounter = 0;
            if (s.length() == 1) continue;
            for (int i = 0; i < (s.length() - 1); i++) {
                if (s.charAt(i) == '-') continue;
                int firstDigit = Integer.parseInt(String.valueOf(s.charAt(i)));
                int secondDigit = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                if ((firstDigit + 1) == secondDigit){
                    validCounter++;
                }else break;
            }
            if (s.contains("-") && validCounter == (s.length() - 2)){
                increaseNumber = s;
                break;
            }
            if (validCounter == s.length() - 1){
                increaseNumber = s;
                break;
            }
        }
        System.out.println("Golden number:" + increaseNumber); //6

        for (String s: inputArray) {
            boolean abort = false;
            for (int i = 0; i < (s.length() - 1); i++) {
                if (abort){break;}
                int searchNumber =  Integer.parseInt(String.valueOf(s.charAt(i)));
                for (int j = (i + 1); j < s.length(); j++) {
                    int comparableNumber = Integer.parseInt(String.valueOf(s.charAt(j)));
                    if (searchNumber == comparableNumber){
                        abort = true;
                        break;
                    }
                }
            }
            System.out.println("Searching number is : " + s);
            System.exit(0); //7
        }
    }
}
