package object_oriented_programming.class_examples;

public class Dog extends Animal {
    private boolean IDName = false;

    public Dog(String name, String color, boolean vegetarian) {
        super(name, color, vegetarian);
    }
    public Dog(String name, String color, boolean vegetarian, boolean IDName){
        this(name, color, vegetarian);
        this.IDName = IDName;
    }
    public Dog(Animal animal, boolean IDName){
        super(animal.getName(), animal.getColor(), animal.getVegetarian());
        this.IDName = IDName;
    }

    public boolean getIDName() {
        return IDName;
    }
    public void animalSOund(){
        System.out.println("Barks");
    }
}