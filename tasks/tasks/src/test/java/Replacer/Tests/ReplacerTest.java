package Replacer.Tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import  Replacer.Replacer;

import java.util.ArrayList;
import java.util.List;

public class ReplacerTest {

    private Replacer replacer;
    @Before
    public void setup(){
        replacer = new Replacer();
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
    public void convertToDigitStringTest(){
        String expected = "1 2 3 ";
        List<Character> data = new ArrayList<>();
        data.add('A');
        data.add('B');
        data.add('C');
        assertEquals(expected,replacer.convertToDigitString(data));
    }

    @Test
    public void convertTest(){
        assertEquals("20 8 9 19 14 5 20 2 21 9 12 4 5 18 1 19 19 5 19 19 13 5 14 20 9 19 23 1 25 20 15 5 1 19 25 ", replacer.convert("This NETbuilder assessment is way to easy."));
    }
}
