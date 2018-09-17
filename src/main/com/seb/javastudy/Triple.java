package main.com.seb.javastudy;

/**
 * Created by seb on 2018. 9. 10..
 */
public class Triple {
    private int card0;
    private int card1;
    private int card2;

    public Triple(int card0, int card1, int card2) {
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
    }

    public Triple() {
    }

    public int getCard0() {
        return card0;
    }

    public int getCard1() {
        return card1;
    }

    public int getCard2() {
        return card2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple triple = (Triple) o;

        if (card0 != triple.card0) return false;
        if (card1 != triple.card1) return false;
        return card2 == triple.card2;
    }

    @Override
    public int hashCode() {
        int result = card0;
        result = 31 * result + card1;
        result = 31 * result + card2;
        return result;
    }
}
