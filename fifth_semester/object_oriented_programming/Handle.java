package object_oriented_programming;

public class Handle{
    private String shape;
    private String material;
    private float size;
    private boolean useful;
    public Handle(String shape, String material, float size, boolean useful){
        this.shape = shape;
        this.material = material;
        this.size = size;
        this.useful = useful;
    }
    public String getMaterial() {
        return material;
    }
    public String getShape() {
        return shape;
    }
    public float getSize() {
        return size;
    }
    public boolean getUseful(){
        return useful;
    }
}
