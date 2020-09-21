package object_oriented_programming.class_examples;

public class Animal {
    private String name;
    private String color;
    private boolean vegetarian;
    public Animal(String name, String color, boolean vegetarian){
        this.name = name;
        this.color = color;
        this.vegetarian = vegetarian;
    }
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public boolean getVegetarian(){
        return vegetarian;
    }
    public void getIDAnimal(Dog myDog){
        myDog.getIDName();
    }
}



class Cat extends Animal{

    public Cat(String name, String color, boolean vegetarian) {
        super(name, color, vegetarian);
    }
    
}