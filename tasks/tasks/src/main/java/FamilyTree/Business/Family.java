package FamilyTree.Business;

import FamilyTree.Constants.Constants;
import FamilyTree.Domain.Person;

import java.util.*;

public class Family {
    private Map<String, Person> family;

    public Family() {
        family = new HashMap<>();
    }

    public boolean add(String name) {
        return add(name, Constants.NONE);
    }

    private boolean add(String name, String gender) {
        boolean isAdded = false;
        Optional<Person> oPerson = get(name);
        if (!oPerson.isPresent()) {
            Person person = new Person(name, gender);
            family.put(name, person);
            isAdded = true;
        } else if (oPerson.get().getGender().equals(Constants.NONE) && !gender.equals(Constants.NONE)) {
            oPerson.get().setGender(gender);
            isAdded = true;
        }
        return isAdded;
    }

    public boolean male(String name) {
        return add(name, Constants.MALE);
    }

    public boolean female(String name) {
        return add(name, Constants.FEMALE);
    }

    public boolean isMale(String name) {
        return isGender(name, Constants.MALE);
    }

    public boolean isFemale(String name) {
        return isGender(name, Constants.FEMALE);
    }

    private boolean isGender(String name, String gender) {
        boolean isGender = false;
        if (get(name).isPresent()) {
            isGender = get(name).get().getGender().equals(gender);
        }
        return isGender;
    }

    private Optional<Person> get(String name) {
        Optional<Person> person = Optional.empty();
        if (family.get(name) != null) {
            person = Optional.of(family.get(name));
        }
        return person;
    }

    public boolean setParent(String childName, String parentName) {
        boolean isSet = false;
        Optional<Person> oChild = get(childName);
        Optional<Person> oParent = get(parentName);

        if (oChild.isPresent() && oParent.isPresent()) {//both exist
            Person child = oChild.get();
            Person parent = oParent.get();
            if (parent.getGender().equals(Constants.FEMALE) && !child.getParentByPos(Constants.FEMALE_PARENT_POS).isPresent()) {
                child.addParent(parent, Constants.FEMALE_PARENT_POS);
                parent.addChild(child);
                isSet = true;
            } else if (parent.getGender().equals(Constants.MALE) && !child.getParentByPos(Constants.MALE_PARENT_POS).isPresent()) {
                child.addParent(parent, Constants.MALE_PARENT_POS);
                parent.addChild(child);
                isSet = true;
            }
        }
        return isSet;
    }

    public String[] getParents(String name) {
        Optional<Person> person = get(name);
        String parentNames[] = new String[2];
        if (person.isPresent()) {
            Person parents[] = person.get().getParents();
            for (int i = 0; i < 2; i++) {
                parentNames[i] = parents[i].getName();
            }
        }
        Arrays.sort(parentNames);
        return parentNames;
    }


    public String[] getChildren(String name) {
        Optional<Person> oPerson = get(name);
        String children[] = new String[0];
        if (oPerson.isPresent()) {
            Person person = oPerson.get();
            children = new String[person.getNumChildren()];
            List<Person> childrenList = person.getChildren();
            for (int i = 0; i < childrenList.size(); i++) {
                children[i] = childrenList.get(i).getName();
            }
        }
        Arrays.sort(children);
        return children;
    }

}
