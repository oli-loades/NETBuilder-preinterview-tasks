package ReplacerTests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ReplacerTest {

    @Before
    public void setup(){
        Replacer replacer = new Replace();
    }

    @Test
    public void extractToListTest(){
        List<Character> expected = new ArrayList<>();
        expected.add('A');
        expected.add('B');
        expected.add('C');
        assertEquals(expected,replacer.extractToList("abc"));
    }

    @Test
    public void convertToDigitString(){
        String expected = "1 2 3";
        List<Character> data = new ArrayList<>();
        data.add('A');
        data.add('B');
        data.add('C');
        assertEquals(expected,replacer.convertToDigitString(data));
    }
}
