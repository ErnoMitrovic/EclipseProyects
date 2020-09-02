package object_oriented_programming.homeworks;

public class Screen {
    private float width;
    private float length;
    private String material;
    boolean isErgonomic = true;
    public Screen(float width, float length, String material, boolean isErgonomic){
        this.width = width;
        this.length = length;
        this.material = material;
        this.isErgonomic = isErgonomic;
    }
    public float getLength() {
        return length;
    }
    public String getMaterial() {
        return material;
    }
    public float getWidth() {
        return width;
    }
}
