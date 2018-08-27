package main.com.seb.javastudy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeCardsSelector {

    public static void main(String[] args) throws IOException {
        run(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
    }

    public static void run(Reader reader, Writer writer) throws IOException{
        BufferedReader in = new BufferedReader(reader);
        PrintWriter out = new PrintWriter(writer);

        String input = in.readLine();
        String answer = in.readLine();

        String[] inputNumbers = input.split(" ");

        List<String> numbers = Arrays.asList(inputNumbers);

        List<Integer> validNumList = numbers.stream()
                .filter(num -> lessOrEquals(num, answer))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        print(out, getCorrectPartArrays(validNumList, Integer.parseInt(answer)));
    }

    private static void print(PrintWriter out, List<int[]> answerPartArrays) {
        if (answerPartArrays.isEmpty()) {
            out.println("NO");
        } else {
            answerPartArrays.forEach(v -> out.println(Arrays.toString(v)));
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
