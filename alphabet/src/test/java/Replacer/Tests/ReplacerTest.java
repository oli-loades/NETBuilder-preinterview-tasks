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
    public void convertToDigitString(){
        String expected = "1 2 3 ";
        List<Character> data = new ArrayList<>();
        data.add('A');
        data.add('B');
        data.add('C');
        assertEquals(expected,replacer.convertToDigitString(data));
    }
}
