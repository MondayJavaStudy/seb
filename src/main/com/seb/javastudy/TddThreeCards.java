package main.com.seb.javastudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by seb on 2018. 9. 3..
 */
public class TddThreeCards {
    public List<Triple> find(List<Integer> cards, Integer answer) {
        List<Triple> partArrays = new ArrayList<>();

        Collections.sort(cards);

        for (int i = 0; i < cards.size() - 2; i++) {
            for (int j = i + 1; j < cards.size() - 1; j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    Triple triple = new Triple(cards.get(i), cards.get(j), cards.get(k));
                    if (isCorrect(triple, answer)) {
                        // 중복 제거
                        if (partArrays.isEmpty() || !partArrays.get(partArrays.size() - 1).equals(triple)) {
                            partArrays.add(triple);
                        }
                    }
                }
            }
        }

        return partArrays;
    }

    private static boolean isCorrect(Triple triple, int answer) {
        return triple.getCard0() + triple.getCard1() + triple.getCard2() == answer;
    }
}
