package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish {

    private String name;
    private int weight;
    private String color;

    public Kong(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String status() {
        return String.format("%s, weight: %d, color: %s, short term memory loss: %b",name,weight,color,hasMemoryLoss());
    }

    @Override
    public void feed() {
        weight += 2;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return false;
    }

}
