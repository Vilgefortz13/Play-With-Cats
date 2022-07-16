public class Feeding implements Action {
    @Override
    public void action(int index) {
        if (Main.cats.get(index).getAge() <= 5) {
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 7);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() + 7);
        } else if (Main.cats.get(index).getAge() > 5 && Main.cats.get(index).getAge() <= 10) {
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 5);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() + 5);
        } else {
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 4);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() + 4);
        }
    }
}
