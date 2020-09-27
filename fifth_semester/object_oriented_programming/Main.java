package object_oriented_programming;

import object_oriented_programming.homeworks.Cellphone;
import object_oriented_programming.homeworks.Screen;
import object_oriented_programming.class_examples.Animal;
import object_oriented_programming.class_examples.Dog;

public class Main {
    public static void main(String[] args) {
        Cellphone cell = new Cellphone("Huawei", new Screen(7.0f, 14.55f, "LCD", true), true, true, 3);
        cell.changeStatus();
        System.out.println(cell.status);
        cell.changeStatus();
        System.out.println(cell.status);
        Animal myAnimal = new Animal("Spike", "black", true);
        Dog myDog = new Dog(myAnimal, true);
        if (!myDog.equals(myAnimal)){
            System.out.println("Claro");
        }
    }
}
