package test.com.seb.javastudy;

import main.com.seb.javastudy.ThreeCardsSelector;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by seb on 2018. 8. 27..
 */
public class ThreeCardsSelectorTest {
    @Test
    public void test() throws Exception {
        Reader input = new StringReader("1 2 3 4 5\n8");
        StringWriter output = new StringWriter();

        ThreeCardsSelector.run(input, output);

        assertEquals("[1, 2, 5]\n" + "[1, 3, 4]\n", output.toString());
    }
}