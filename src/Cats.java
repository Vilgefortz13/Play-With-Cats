public class Cats {
    private String name;
    private Integer age;
    private Integer satiety;
    private Integer mood;
    private Integer health;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSatiety() {
        return satiety;
    }

    public Integer getMood() {
        return mood;
    }

    public Integer getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", satiety=" + satiety +
                ", mood=" + mood +
                ", health=" + health +
                '}';
    }
}
