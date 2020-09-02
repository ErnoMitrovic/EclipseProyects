package object_oriented_programming;

public class Cup {
    public String color;
    public String material;
    public String shape;
    public boolean bottom; //flat = true, notflat = false
    public Handle handle;
    public Cup(String color, String material, String shape, boolean bottom){
        this.color = color;
        this.material = material;
        this.shape = shape;
        this.bottom = bottom;
    }
    public Cup(String color, String material, String shape, boolean bottom, Handle handle){
        this(color, material, shape, bottom);
        this.handle = handle;
    }
}