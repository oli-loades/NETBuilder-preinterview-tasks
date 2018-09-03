package Replacer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Replacer {
    private Map<Character, Integer> posInAlphabet;

    public Replacer() {
        posInAlphabet = new HashMap<>();
        init();
    }

    private void init() {
        posInAlphabet.put('A',1);
        posInAlphabet.put('B',2);
        posInAlphabet.put('C',3);
        posInAlphabet.put('D',4);
        posInAlphabet.put('E',5);
        posInAlphabet.put('F',6);
        posInAlphabet.put('G',7);
        posInAlphabet.put('H',8);
        posInAlphabet.put('I',9);
        posInAlphabet.put('J',10);
        posInAlphabet.put('K',11);
        posInAlphabet.put('L',12);
        posInAlphabet.put('M',13);
        posInAlphabet.put('N',14);
        posInAlphabet.put('O',15);
        posInAlphabet.put('P',16);
        posInAlphabet.put('Q',17);
        posInAlphabet.put('R',18);
        posInAlphabet.put('S',19);
        posInAlphabet.put('T',20);
        posInAlphabet.put('U',21);
        posInAlphabet.put('V',22);
        posInAlphabet.put('W',23);
        posInAlphabet.put('X',24);
        posInAlphabet.put('Y',25);
        posInAlphabet.put('Z',26);
    }

    public List<Character> extractToList(String string) {
        return string.toUpperCase().chars().mapToObj(c -> (char) c).filter(Character::isAlphabetic).collect(Collectors.toList());
    }

    public String convertToDigitString(List<Character> chars) {
        String result = "";
        for(char c: chars){
            result +=  posInAlphabet.get(c) + " ";
        }
        return result;
    }

    public String convert(String toConvert){
        return convertToDigitString(extractToList(toConvert));
    }
}
