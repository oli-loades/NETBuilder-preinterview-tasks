package FanilyTree.Tests;

import FamilyTree.Business.Family;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FamilyTreeTest {
    private Family fam;

    @Before
    public void setup(){
        fam = new Family();
    }

    @Test
    public void addTest(){//genderless
        assertEquals(true,fam.add("bob"));
        assertEquals(false,fam.add("bob"));
    }

    @Test
    public void maleTest(){//sets male
        assertEquals(true,fam.male("bob"));
        assertEquals(false,fam.male("bob"));
    }

    @Test
    public void femaleTest(){//sets female
        assertEquals(true,fam.female("sue"));
        assertEquals(false,fam.female("sue"));
    }

    @Test
    public void isMaleTest(){//checks if male
        fam.male("bob");
        fam.female("sue");
        fam.add("rob");
        assertEquals(true,fam.isMale("bob"));
        assertEquals(false,fam.isMale("sue"));
        assertEquals(false,fam.isMale("rob"));
    }

    @Test
    public void isFemaleTest(){//checks if female
        fam.male("bob");
        fam.female("sue");
        fam.add("rob");
        assertEquals(false,fam.isFemale("bob"));
        assertEquals(true,fam.isFemale("sue"));
        assertEquals(false,fam.isFemale("rob"));
    }

    @Ignore
    @Test
    public void setParentTest(){

    }

    @Ignore
    @Test
    public void getParentTest(){

    }

    @Ignore
    @Test
    public void getChildrenTest(){

    }
}
