package object_oriented_programming.homeworks;

public class Cellphone {
    private String brand;
    Screen screen;
    public boolean isFaceRecon;
    public boolean isFingerPrint;
    private int cameraNum;
    public boolean status;
    public Cellphone(String brand, Screen screen, boolean isFaceRecon, boolean isFingerPrint, int cameraNum){
        this.brand = brand;
        this.screen = screen;
        this.isFaceRecon = isFaceRecon;
        this.isFingerPrint = isFingerPrint;
        this.cameraNum = cameraNum;
        status = false;
    }
    public String getBrand(){
        return brand;
    }
    public int getCameraNum() {
        return cameraNum;
    }
    public void changeStatus(){
        if(!status){
            this.status = true;
            System.out.println("Turning on");
        }
        else{
            status = false;
            System.out.println("Turning off");
        }
    }
}