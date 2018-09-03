package FamilyTree.Domain;

public class Person {
    private String name;
    private String gender;

    public Person (){
        this.name = "";
        this.gender = "";
    }

    public Person(String name){
        this.name = name;
        this.gender = "";
    }

    public Person(String name, String gender){
        this.name = name;
        this.gender=gender;
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
}
