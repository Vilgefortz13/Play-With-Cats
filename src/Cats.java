public class Cats {
    private String name;
    private Integer age;
    private Integer satiety;
    private Integer mood;
    private Integer health;

    public Cats(String name, Integer age, Integer satiety, Integer mood, Integer health) {
        this.name = name;
        this.age = age;
        this.satiety = satiety;
        this.mood = mood;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSatiety() {
        return satiety;
    }

    public void setSatiety(Integer satiety) {
        this.satiety = satiety;
    }

    public Integer getMood() {
        return mood;
    }

    public void setMood(Integer mood) {
        this.mood = mood;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
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
