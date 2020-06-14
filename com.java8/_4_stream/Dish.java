package _4_stream;

public class Dish {
    private final String name;

    private final boolean vagetaruian;

    private final int calories;

    private final Type type;

    public enum Type {MEAT,FISH,OTHER}

    public Dish(String name, boolean vagetaruian, int calories, Type type) {
        this.name = name;
        this.vagetaruian = vagetaruian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public boolean isVagetaruian() {
        return vagetaruian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
}
