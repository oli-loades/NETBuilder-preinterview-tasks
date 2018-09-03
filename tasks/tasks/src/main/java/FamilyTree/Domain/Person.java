package FamilyTree.Domain;

import FamilyTree.Constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Person {
    private String name;
    private String gender;
    private Person[] parents;
    private List<Person> children;

    public Person (){
        this.name = "";
        this.gender = "";
        parents = new Person[2];
        children = new ArrayList<>();
    }

    public Person(String name){
        this.name = name;
        this.gender = "";
        parents = new Person[2];
        children = new ArrayList<>();
    }

    public Person(String name, String gender){
        this.name = name;
        this.gender=gender;
        parents = new Person[2];
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addChild(Person child){
        children.add(child);
    }

    public void addParent(Person parent,int pos){
            parents[pos] = parent;
    }

    public Person[] getParents(){
        return parents;
    }

    public List<Person> getChildren(){
        return children;
    }

    public Optional<Person> getParentByPos(int pos){
       Optional<Person> parent = Optional.empty();
        if(parents[pos]!=null){
            parent = Optional.of(parents[pos]);
        }
        return parent;
    }

    public int getNumChildren(){
        return children.size();
    }
}
