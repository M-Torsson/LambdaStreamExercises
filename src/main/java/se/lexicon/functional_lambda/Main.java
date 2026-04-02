package se.lexicon.functional_lambda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // simple lambda example (Task)
        Task task = () -> System.out.println("Task executed");
        task.execute();

        Task task2 = () -> System.out.println("Second task");
        task2.execute();

        // sample data
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // Exercise Part 1 - rules using lambda
        PersonRule isActive = person -> person.isActive();
        PersonRule isAdult = person -> person.getAge() >= 18;
        PersonRule livesInStockholm = person -> person.getCity().equals("Stockholm");

        // Exercise Part 1 - filtering with custom method
        List<Person> activePeople = filterPeople(people, isActive);
        System.out.println("Active people:");
        activePeople.forEach(person -> System.out.println(person));

        List<Person> adults = filterPeople(people, isAdult);
        System.out.println("\nAdults:");
        adults.forEach(person -> System.out.println(person));

        List<Person> stockholmPeople = filterPeople(people, livesInStockholm);
        System.out.println("\nStockholm people:");
        stockholmPeople.forEach(person -> System.out.println(person));

        // Exercise Part 1 - actions using functional interface
        PersonAction printName = person -> System.out.println(person.getName());
        PersonAction sendEmail = person -> System.out.println("Send email to " + person.getName());

        System.out.println("\n--- PersonAction: Print Names ---");
        people.forEach(person -> printName.apply(person));

        System.out.println("\n--- PersonAction: Send Emails ---");
        people.forEach(person -> sendEmail.apply(person));

        // Exercise Part 2 - 1. Filter all active people
        System.out.println("\n--- Stream: Active People ---");
        people.stream()
                .filter(person -> person.isActive())
                .forEach(person -> System.out.println(person));

        // Exercise Part 2 - 2. Map all names
        System.out.println("\n--- Stream: Names ---");
        people.stream()
                .map(person -> person.getName())
                .forEach(name -> System.out.println(name));

        // Exercise Part 2 - 3. Count adults
        System.out.println("\n--- Stream: Count Adults ---");
        long count = people.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println("Number of adults: " + count);

        // Exercise Part 2 - 4. Sort by age
        System.out.println("\n--- Stream: Sort by Age ---");
        people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(person -> System.out.println(person));

        // Exercise Part 2 - 5. Find first active in Stockholm
        System.out.println("\n--- Stream: First Active in Stockholm ---");
        people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getCity().equals("Stockholm"))
                .findFirst()
                .ifPresent(person -> System.out.println(person));

        // Extra practice - multiple filters
        System.out.println("\n--- Stream: Active Adults ---");
        people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getAge() >= 18)
                .forEach(person -> System.out.println(person));

        // Extra practice - distinct cities
        System.out.println("\n--- Stream: Unique Cities ---");
        people.stream()
                .map(person -> person.getCity())
                .distinct()
                .forEach(city -> System.out.println(city));

        // Extra practice - formatting output
        System.out.println("\n--- Stream: Formatted People ---");
        people.stream()
                .map(person -> person.getName() + " (" + person.getAge() + ") - " + person.getCity())
                .forEach(text -> System.out.println(text));

        // Extra practice - create emails
        System.out.println("\n--- Stream: Emails ---");
        people.stream()
                .map(person -> person.getName().toLowerCase() + "@example.com")
                .forEach(email -> System.out.println(email));

        // Extra practice - sorted unique cities
        System.out.println("\n--- Stream: Sorted Unique Cities ---");
        people.stream()
                .map(person -> person.getCity())
                .distinct()
                .sorted()
                .forEach(city -> System.out.println(city));
    }

    // Part 1 - custom filter method using rule
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