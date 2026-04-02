package se.lexicon.functional_lambda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Task task = () -> System.out.println("Task executed");
        task.execute();

        Task task2 = () -> System.out.println("Second task");
        task2.execute();

        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule livesInStockholm = person -> person.getCity().equals("Stockholm");

        List<Person> activePeople = filterPeople(people, isActive);
        System.out.println("Active people:");
        activePeople.forEach(person -> System.out.println(person));

        List<Person> adults = filterPeople(people, isAdult);
        System.out.println("\nAdults:");
        adults.forEach(person -> System.out.println(person));

        List<Person> stockholmPeople = filterPeople(people, livesInStockholm);
        System.out.println("\nStockholm people:");
        stockholmPeople.forEach(person -> System.out.println(person));
    }

    public static List<Person> filterPeople(List<Person> people, PersonRule rule) {
        List<Person> result = new java.util.ArrayList<>();

        for (Person person : people) {
            if (rule.test(person)) {
                result.add(person);
            }
        }

        return result;
    }
}