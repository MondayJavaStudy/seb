package test.com.seb.javastudy;

import main.com.seb.javastudy.TddThreeCards;
import main.com.seb.javastudy.Triple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by seb on 2018. 9. 3..p
 */
public class TddThreeCardsTest {
    TddThreeCards tddThreeCards = new TddThreeCards();

    @Test
    public void 단순값_반환() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        int answer = 6;

        List<Triple> exp = Arrays.asList(new Triple(1, 2, 3));

        List<Triple> result = tddThreeCards.find(list, answer);
        assertEquals(result.size(), exp.size());
        for (int i = 0; i < exp.size(); i++) {
            assertEquals(result.get(i), exp.get(i));
        }
    }

    @Test
    public void 카드_순서() throws Exception {
        List<Integer> list = Arrays.asList(2, 1, 3, 4);

        int answer = 6;

        List<Triple> exp = Arrays.asList(new Triple(1, 2, 3));

        List<Triple> result = tddThreeCards.find(list, answer);
        assertEquals(result.size(), exp.size());
        for (int i = 0; i < exp.size(); i++) {
            assertEquals(result.get(i), exp.get(i));
        }
    }

    @Test
    public void 결과가_여러개() throws Exception {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);

        int answer = 5;

        List<Triple> exp = Arrays.asList(new Triple(0 ,1,4), new Triple(0,2,3));

        List<Triple> result = tddThreeCards.find(list, answer);
        assertEquals(result.size(), exp.size());
        for (int i = 0; i < exp.size(); i++) {
            assertEquals(result.get(i), exp.get(i));
        }
    }

    @Test
    public void 중복없어야함() throws Exception {
        List<Integer> list = Arrays.asList(1, 1, 2, 3);

        int answer = 6;

        List<Triple> exp = Arrays.asList(new Triple(1, 2, 3));

        List<Triple> result = tddThreeCards.find(list, answer);
        assertEquals(result.size(), exp.size());
        for (int i = 0; i < exp.size(); i++) {
            assertEquals(result.get(i), exp.get(i));
        }
    }
}
