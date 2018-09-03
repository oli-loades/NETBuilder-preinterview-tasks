package FamilyTree.Business;

import FamilyTree.Constants.Constants;
import FamilyTree.Domain.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (family.get(name) == null) {
            Person person = new Person(name, gender);
            family.put(name, person);
            isAdded = true;
        } else if (family.get(name).getGender().equals(Constants.NONE) && !gender.equals(Constants.NONE)) {
            family.get(name).setGender(gender);
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

    public boolean isGender(String name, String gender) {
        boolean isGender = false;
        if (family.get(name) != null) {
            isGender = family.get(name).getGender().equals(gender);
        }
        return isGender;
    }

    public boolean setParent(String childName, String parentName) {
        boolean isSet = false;
        Person child = family.get(childName);
        Person parent = family.get(parentName);

        if (child != null && parent != null) {//both exist
            if (parent.getGender().equals(Constants.FEMALE) && !child.getParentByPos(Constants.FEMALE_PARENT_POS).isPresent()) {//MOTHER
                child.addParent(parent, Constants.FEMALE_PARENT_POS);
                parent.addChild(child);
                isSet = true;
            } else if (parent.getGender().equals(Constants.MALE) && !child.getParentByPos(Constants.MALE_PARENT_POS).isPresent()) {//FATHER
                child.addParent(parent, Constants.MALE_PARENT_POS);
                parent.addChild(child);
                isSet = true;
            }
        }
        return isSet;
    }

    public String[] getParents(String name) {
        Person person = family.get(name);
        String parentNames[] = new String[2];
        if (person != null) {
            Person parents[] = person.getParents();
            for (int i = 0; i < 2; i++) {
                parentNames[i] = parents[i].getName();
            }
        }
        Arrays.sort(parentNames);
        return parentNames;
    }


    public String[] getChildren(String name) {
        Person person = family.get(name);
        String children[] = new String[0];
        if (person != null) {
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
