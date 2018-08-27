package com.seb.javastudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input = in.readLine();
        String answer = in.readLine();

        String[] inputNumbers = input.split(" ");

        List<String> numbers = Arrays.asList(inputNumbers);

        List<Integer> validNumList = numbers.stream()
                .filter(num -> lessOrEquals(num, answer))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        List<int[]> answerPartArrays = getCorrectPartArrays(validNumList, Integer.parseInt(answer));

        if (answerPartArrays.isEmpty()) {
            System.out.println("NO");
        } else {
            answerPartArrays.forEach(v -> System.out.println(Arrays.toString(v)));
        }
    }

    private static boolean lessOrEquals(String num0, String num1) {
        return Integer.parseInt(num0) <= Integer.parseInt(num1);
    }

    private static List<int[]> getCorrectPartArrays(List<Integer> inputList, int answer) {
        List<int[]> partArrays = new ArrayList<>();

        for (int i = 0; i < inputList.size() - 2; i++) {
            for (int j = i + 1; j < inputList.size() - 1; j++) {
                for (int k = j + 1; k < inputList.size(); k++) {
                    int[] partArray = {inputList.get(i), inputList.get(j), inputList.get(k)};
                    if (isCorrectArray(partArray, answer)) {
                        // 중복 제거
                        if (partArrays.isEmpty() || !equals(partArrays.get(partArrays.size() - 1), partArray)) {
                            partArrays.add(partArray);
                        }
                    }
                }
            }
        }

        return partArrays;
    }

    private static boolean isCorrectArray(int[] inputArray, int answer) {
        return inputArray[0] + inputArray[1] + inputArray[2] == answer;
    }

    private static boolean equals(int[] array0, int[] array1) {
        return array0[0] == array1[0] && array0[1] == array1[1] && array0[2] == array1[2];
    }
}
