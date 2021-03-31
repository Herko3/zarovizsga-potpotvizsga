package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    private String name;
    private int weight;
    private String color;
    private boolean memoryLoss;

    public Fish(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String status(){
        return String.format("%s, weight: %d, color: %s, short term memory loss: %b",name,weight,color,memoryLoss);
    }
    public abstract void feed();

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
        return memoryLoss;
    }

   public void increaseWeight(int plus){
        weight += plus;
   }

    public void setMemoryLoss(boolean memoryLoss) {
        this.memoryLoss = memoryLoss;
    }
}
