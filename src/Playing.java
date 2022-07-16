public class Playing implements Action {
    @Override
    public void action(int index) {
        if (Main.cats.get(index).getAge() <= 5) {
            Main.cats.get(index).setHealth(Main.cats.get(index).getHealth() + 7);
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 7);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() - 3);
        } else if (Main.cats.get(index).getAge() > 5 && Main.cats.get(index).getAge() <= 10) {
            Main.cats.get(index).setHealth(Main.cats.get(index).getHealth() + 5);
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 5);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() - 5);
        } else {
            Main.cats.get(index).setHealth(Main.cats.get(index).getHealth() + 4);
            Main.cats.get(index).setMood(Main.cats.get(index).getMood() + 4);
            Main.cats.get(index).setSatiety(Main.cats.get(index).getSatiety() - 6);
        }
    }
}
