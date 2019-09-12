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
        String longestNumber = inputArray[0];
        String shorterNumber = inputArray[0];

        for (String i:inputArray) {
            longestNumber = longestNumber.length() > i.length() ? longestNumber : i;
            shorterNumber = shorterNumber.length() < i.length() ? shorterNumber : i;
        }
        System.out.println("Number " + longestNumber + " have " + longestNumber.length()+ " symbol(s)");
        System.out.println("Number " + shorterNumber + " have " + shorterNumber.length() + " symbol(s)");  //1

        String temp;
        for (int j = 0; j < (n - 1); j++) {
            for (int i = 0; i < (n - 1); i++) {
                if (inputArray[i].length() < inputArray[i + 1].length()){
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(inputArray));  //2

        int sum = 0;
        for (String s:inputArray) {
            sum += s.length();
        }
        int average = sum / n;
        System.out.print("Number with length less than average:");
        for (String s:inputArray) {
            if (s.length() < average) System.out.print(" " + s + "(" + s.length() + " symbol(s))");  //3
        }
        System.out.println();

        String simplestNumber = null;
        int minAmountSymbols = (int) inputArray[0].chars().distinct().count();
        for (String s: inputArray) {
            if (s.contains("-")){
                if ((s.chars().distinct().count() - 1) < minAmountSymbols){
                    minAmountSymbols = (int) (s.chars().distinct().count() - 1) ;
                    simplestNumber = s;
                }
            }else if(s.chars().distinct().count() < minAmountSymbols){
                minAmountSymbols = (int) s.chars().distinct().count();
                simplestNumber = s;
            }
        }
        System.out.println("The simplest number is: " + simplestNumber);  //4

        int onlyEvenDigitsInNumber = 0;
        int equalEvenAndUneven = 0;
        for (String s:inputArray) {
            int evenDigits = 0;
            int unevenDigits = 0;
            for (int i = 0; i <s.length() ; i++) {
                if (s.charAt(i) == '1' || s.charAt(i) == '3' || s.charAt(i) == '5' || s.charAt(i) == '7' || s.charAt(i) == '9'){
                    unevenDigits++;
                }else evenDigits++;
            }
            if (unevenDigits == 0){onlyEvenDigitsInNumber++;}
            if (evenDigits == unevenDigits){equalEvenAndUneven++;}
        }
        System.out.println("Amount of numbers with only even digits is: " + onlyEvenDigitsInNumber);
        System.out.println("Amount of numbers with equal even and uneven digits is: " + equalEvenAndUneven);
    }
}
