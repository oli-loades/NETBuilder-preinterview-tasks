package FanilyTree.Tests;

import FamilyTree.Business.Family;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FamilyTreeTest {
    private Family fam;

    @Before
    public void setup(){
        fam = new Family();
    }

//    @Test
//    public void addTest(){//genderless
//        assertEquals(true,fam.add("bob"));
//        assertEquals(false,fam.add("bob"));
//    }
//
//    @Test
//    public void maleTest(){//sets male
//        assertEquals(true,fam.male("bob"));
//        assertEquals(false,fam.male("bob"));
//    }
//
//    @Test
//    public void femaleTest(){//sets female
//        assertEquals(true,fam.female("sue"));
//        assertEquals(false,fam.female("sue"));
//    }
//
//    @Test
//    public void isMaleTest(){//checks if male
//        fam.male("bob");
//        fam.female("sue");
//        fam.add("rob");
//        assertEquals(true,fam.isMale("bob"));
//        assertEquals(false,fam.isMale("sue"));
//        assertEquals(false,fam.isMale("rob"));
//    }
//
//    @Test
//    public void isFemaleTest(){//checks if female
//        fam.male("bob");
//        fam.female("sue");
//        fam.add("rob");
//        assertEquals(false,fam.isFemale("bob"));
//        assertEquals(true,fam.isFemale("sue"));
//        assertEquals(false,fam.isFemale("rob"));
//    }

    @Test
    public void setParentTest(){
        fam.male("bob");
        fam.female("sue");
        fam.male("rob");
        fam.female("Kat");

        assertEquals(true,fam.setParent("bob","rob"));
        assertEquals(true,fam.setParent("bob","sue"));
        assertEquals(false,fam.setParent("bob","kat"));

        //cannot be own ancester
    }

    @Test
    public void getParentTest(){
        fam.male("bob");
        fam.female("sue");
        fam.male("rob");

        fam.setParent("bob","rob");
        fam.setParent("bob","sue");

        String[] expected = {"rob", "sue"};

        assertEquals(expected,fam.getParents("bob"));
    }

    @Test
    public void getChildrenTest(){
        fam.male("bob");
        fam.female("sue");
        fam.male("rob");

        fam.setParent("bob","rob");
        fam.setParent("sue","rob");

        String[] expected = {"bob", "sue"};

        assertEquals(expected,fam.getChildren("rob"));
    }
}
