package FamilyTree.Domain;

import java.util.HashMap;
import java.util.Map;

public class Family {
    private Map<String, Person> family;

    public Family() {
        family = new HashMap<String, Person>();
    }

    public boolean add(String name) {
        boolean isAdded = false;
        if (family.get(name) == null) {
            Person person = new Person(name);
            family.put(name, person);
            isAdded = true;
        }
        return isAdded;
    }

    public boolean male(String name) {
        boolean isAdded = false;
        if (family.get(name) == null) {
            Person person = new Person(name, "m");
            family.put(name, person);
            isAdded = true;
        } else {
            if (family.get(name).getGender().equals("")) {
                family.get(name).setGender("m");
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean female(String name) {
        boolean isAdded = false;
        if (family.get(name) == null) {
            Person person = new Person(name, "f");
            family.put(name, person);
            isAdded = true;
        } else {
            if (family.get(name).getGender().equals("")) {
                family.get(name).setGender("f");
                isAdded = true;
            }
        }
        return isAdded;
    }

    public boolean isMale(String name){
        boolean isMale = false;
        if (family.get(name) != null) {
            isMale = family.get(name).getGender().equals("m");
        }
        return isMale;
    }

    public boolean isFemale(String name){
        boolean isMale = false;
        if (family.get(name) != null) {
            isMale = family.get(name).getGender().equals("f");
        }
        return isMale;
    }

}
