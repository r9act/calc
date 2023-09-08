package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String expression = "1+2*3-4-1";
        System.out.println(parseEquation(expression));
        System.out.println(process(parseEquation(expression)));
    }

    public static double process(List<String> list) {
        while (list.size() != 0) {
            Double result = 0d;

            if (list.indexOf("/") != -1) {
                int index = list.indexOf("/");
                result = Double.valueOf(list.get(index - 1)) / (Double.valueOf(list.get(index + 1)));
                list.add(index - 1, String.valueOf(result));
                list.remove(index + 2);
                list.remove(index + 1);
                list.remove(index);
            } else if (list.indexOf("*") != -1) {
                int index = list.indexOf("*");
                result = Double.valueOf(list.get(index - 1)) * Double.valueOf(list.get(index + 1));
                list.add(index - 1, String.valueOf(result));
                list.remove(index + 2);
                list.remove(index + 1);
                list.remove(index);
            } else if (list.indexOf("-") != -1) {
                int index = list.indexOf("-");
                int lastIndex = list.lastIndexOf("-");
                if (index == 0) {
                    result = 0.0 - Double.valueOf(list.get(index + 1));
                    list.add(0, String.valueOf(result));
                    list.remove(2);
                    list.remove(1);
                } else if (list.get(lastIndex - 2).equals("-")) {
                    result = Double.valueOf(list.get(lastIndex - 1)) + Double.valueOf(list.get(lastIndex + 1));
                    list.add(lastIndex - 1, String.valueOf(result));
                    list.remove(lastIndex + 2);
                    list.remove(lastIndex + 1);
                    list.remove(lastIndex);
                } else {
                    result = Double.valueOf(list.get(index - 1)) - Double.valueOf(list.get(index + 1));
                    list.add(index - 1, String.valueOf(result));
                    list.remove(index + 2);
                    list.remove(index + 1);
                    list.remove(index);
                }
            } else if (list.indexOf("+") != -1) {
                int index = list.indexOf("+");
                result = Double.valueOf(list.get(index - 1)) + Double.valueOf(list.get(index + 1));
                list.add(index - 1, String.valueOf(result));
                list.remove(index+2);
                list.remove(index+1);
                list.remove(index);
            }
            if ((list.indexOf("*") == -1) && (list.indexOf("/") == -1) && (list.indexOf("+") == -1)
                    && (list.indexOf("-") == -1)) {
                return result;
            }
        }
        return Double.valueOf(list.get(0));
    }


    public static List<String> parseEquation(String expression) {
        List<String> list = new ArrayList<>();
//        list.add("+");
        for (String element : expression.split("")) {

            list.add(element);
        }
        return list;
    }

}
