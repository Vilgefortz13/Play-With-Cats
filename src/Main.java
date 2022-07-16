import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {

    static List<Cats> cats = Arrays.asList(
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
                    12,
                    getRandomNumber(),
                    getRandomNumber(),
                    getRandomNumber())
    );

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        printCats(cats);
        while (true) {
            cats = cats.stream()
                    .sorted(Collections.reverseOrder(Comparator.comparing(Cats::getAverage)))
                    .collect(toList());

            System.out.print("""
                    \nEnter the action:
                      add the cat - 1;
                      feed - 2;
                      play - 3;
                      take to the vet - 4;
                      next day - 5;
                      complete the program - 6
                    >\040""");
            int action = getNumber(1, 6);
            if (action == 6) {
                break;
            }
            doAction(cats, action);
            printCats(cats);
        }
    }

    private static void doAction(List<Cats> cats, int action) {
        switch (action) {
            case 1 -> {
                System.out.print("Enter cat's name: ");
                String name = firstUpperCase(getString(new Scanner(System.in)));
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
                int index = getNumber(1, cats.size()) - 1;
                System.out.println("You fed " + cats.get(index).getName());
                cats.get(index).setActivity(new Feeding());
                cats.get(index).catsAction(index);
            }
            case 3 -> {
                System.out.print("Enter cat's number: ");
                int index = getNumber(1, cats.size()) - 1;
                System.out.println("You played with " + cats.get(index).getName());
                cats.get(index).setActivity(new Playing());
                cats.get(index).catsAction(index);
            }
            case 4 -> {
                System.out.print("Enter cat's number: ");
                int index = getNumber(1, cats.size()) - 1;
                System.out.println("You healed " + cats.get(index).getName());
                cats.get(index).setActivity(new Healing());
                cats.get(index).catsAction(index);
            }
            case 5 -> {
                Random rnd = new Random();
                for (Cats cat : cats) {
                    cat.setSatiety(cat.getSatiety() - rnd.nextInt(1,6));
                    cat.setMood(cat.getMood() + rnd.nextInt(-3, 4));
                    cat.setHealth(cat.getHealth() + rnd.nextInt(-3, 4));
                }
            }
            default -> System.out.println();
        }
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
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