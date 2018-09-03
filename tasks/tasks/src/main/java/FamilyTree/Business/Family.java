package FamilyTree.Business;

import FamilyTree.Constants.Constants;
import FamilyTree.Domain.Person;

import java.util.HashMap;
import java.util.Map;

public class Family {
    private Map<String, Person> family;

    public Family() {
        family = new HashMap<>();
    }

    public boolean add(String name){
        return add(name,Constants.NONE);
    }

    private boolean add(String name, String gender) {
        boolean isAdded = false;
        if (family.get(name) == null) {
            Person person = new Person(name,gender);
            family.put(name, person);
            isAdded = true;
        }else if (family.get(name).getGender().equals(Constants.NONE)&&!gender.equals(Constants.NONE)) {
                family.get(name).setGender(gender);
                isAdded = true;
            }
        return isAdded;
    }

    public boolean male(String name) {
            return add(name, Constants.MALE);
    }

    public boolean female(String name) {
            return add(name,Constants.FEMALE);
    }

    public boolean isMale(String name){
        return isGender(name,Constants.MALE);
    }

    public boolean isFemale(String name){
       return isGender(name,Constants.FEMALE);
    }

    public boolean isGender(String name, String gender){
        boolean isGender = false;
        if (family.get(name) != null) {
            isGender = family.get(name).getGender().equals(gender);
        }
        return isGender;
    }

}
