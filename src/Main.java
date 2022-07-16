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
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20),
                new Cats(
                        "Jasper",
                        3,
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20),
                new Cats(
                        "Poppy",
                        10,
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20,
                        (int) (Math.random() * 60) + 20)
        );
        cats = cats.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Cats::getAverage)))
                .collect(toList());

        printCats(cats);
        System.out.print("""
                \nEnter the action:
                  add the cat - 1;
                >\040""");
        int action = getNumber(1, 4);

        System.out.println(action);
    }

    public static void printCats(List<Cats> cats) {
        System.out.println("""
                ---+----------+------+---------+------+--------+---------+
                 # |   name   |  age | satiety | mood | health | average |
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
}