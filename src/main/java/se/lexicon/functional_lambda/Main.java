package se.lexicon.functional_lambda;

public class Main {

    public static void main(String[] args) {

        Task task = () -> System.out.println("Task executed");
        task.execute();

        task.execute();
    }
}