import java.util.ArrayList;
import java.util.Scanner;

class Person {
    private String name;
    private String lastName;
    private String gender;
    private int age;

    // Constructor
    public Person(String name, String lastName, String gender, int age) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

public class ConsoleProgram {
    private static ArrayList<Person> people = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        capturePersons();
        displayNamesAndGenders();
        System.out.println("Average age: " + calculateAverageAge());
        System.out.println("Number of males: " + countMales());
        System.out.println("Number of females: " + countFemales());
    }

    // b) Method to capture and return names and genders of 5 people
    public static void capturePersons() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Gender (M/F): ");
            String gender = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            people.add(new Person(name, lastName, gender, age));
        }
    }

    public static void displayNamesAndGenders() {
        System.out.println("\nNames and Genders:");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getGender());
        }
    }

    // c) Method to calculate and return the average age
    public static double calculateAverageAge() {
        int totalAge = 0;
        for (Person person : people) {
            totalAge += person.getAge();
        }
        return (double) totalAge / people.size();
    }

    // d) Method to count and return the number of males
    public static int countMales() {
        int maleCount = 0;
        for (Person person : people) {
            if (person.getGender().equalsIgnoreCase("M")) {
                maleCount++;
            }
        }
        return maleCount;
    }

    // e) Method to count and return the number of females
    public static int countFemales() {
        int femaleCount = 0;
        for (Person person : people) {
            if (person.getGender().equalsIgnoreCase("F")) {
                femaleCount++;
            }
        }
        return femaleCount;
    }
}