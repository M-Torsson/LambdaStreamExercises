package se.lexicon.functional_lambda;

public class Person {

    private String name;
    private int age;
    private String city;
    private boolean active;

    public Person(String name, int age, String city, boolean active) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return name + " - " + age + " - " + city + " - " + active;
    }
}