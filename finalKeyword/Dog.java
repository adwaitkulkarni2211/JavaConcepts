package finalKeyword;

public class Dog extends Animal {
    private int walkDistance;

    public void bark() {
        System.out.println("WOOF!");
    }

//    @Override
//    public void eat() {
//        System.out.println("CRUNCH CRUNCH CRUNCH!");
//    }

    public int getWalkDistance() {
        return walkDistance;
    }

    public void setWalkDistance(int walkDistance) {
        this.walkDistance = walkDistance;
    }
}
