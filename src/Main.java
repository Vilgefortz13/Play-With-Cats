import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<Cats> cats = Arrays.asList(
                new Cats(
                        "Peach",
                        7,
                        getRandomNumber(),
                        getRandomNumber(),
                        getRandomNumber()),
                new Cats(
                        "Jasper",
                        3,
                        getRandomNumber(),
                        getRandomNumber(),
                        getRandomNumber()),
                new Cats(
                        "Poppy",
                        10,
                        getRandomNumber(),
                        getRandomNumber(),
                        getRandomNumber())
        );
        cats = cats.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Cats::getAverage)))
                .collect(toList());

        printCats(cats);
        System.out.print("""
                \nEnter the action:
                  add the cat - 1;
                  feed - 2;
                  play - 3;
                  take to the vet - 4;
                >\040""");
        int action = getNumber(1, 4);

        doAction(cats, action);
        printCats(cats);
    }

    private static void doAction(List<Cats> cats, int action) {
        switch (action) {
            case 1 -> {
                System.out.print("Enter cat's name: ");
                String name = getString(new Scanner(System.in));
                System.out.print("Enter cat's age (1 - 18): ");
                int age = getNumber(1, 18);
                cats.add(
                        new Cats(name, age,
                                getRandomNumber(),
                                getRandomNumber(),
                                getRandomNumber())
                );
            }
            case 2 -> {
                System.out.print("Enter cat's number: ");
                int number = getNumber(1, cats.size()) - 1;
                System.out.println("You fed " + cats.get(number).getName());
            }
            case 3 -> {
                System.out.print("Enter cat's number: ");
                int number = getNumber(1, cats.size()) - 1;
                System.out.println("You played with " + cats.get(number).getName());
            }
            case 4 -> {
                System.out.print("Enter cat's number: ");
                int number = getNumber(1, cats.size()) - 1;
                System.out.println("You took " + cats.get(number).getName() + " to the vet");
            }
            default -> System.out.println();
        }
    }

    public static void printCats(List<Cats> cats) {
        cats = cats.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Cats::getAverage)))
                .collect(toList());
        System.out.println("""
                ---+----------+------+---------+------+--------+---------+
                 # |     name |  age | satiety | mood | health | average |
                ---+----------+------+---------+------+--------+---------+""");
        int count = 1;
        for (Cats cat : cats) {
            System.out.printf(" %d", count);
            count++;
            System.out.println(cat);
        }
        System.out.println("---+----------+------+---------+------+--------+---------+");
    }

    private static int getNumber(int startValue, int endValue) {
        int value;
        while (true) {
            try {
                value = new Scanner(System.in).nextInt();
                while (value < startValue || value > endValue) {
                    System.out.print("Invalid value! Enter from " + startValue + " to " + endValue + ": ");
                    value = new Scanner(System.in).nextInt();
                }

                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Try again: ");
            }
        }
    }

    private static String getString(Scanner sc) {
        String str = "";
        while (sc.hasNextLine()) {
            try {
                str += sc.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Try again: ");
                sc.nextLine();
            }
        }

        return str;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 60) + 20;
    }
}