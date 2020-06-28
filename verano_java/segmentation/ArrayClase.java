import java.util.Arrays;
public class ArrayClase {
    public static void main(String[] args) {
        int[] desorden = {1,9,2,8,3,7,4,6,5};
        int menor = 0;        
        System.out.println(Arrays.toString(desorden));

        for (int i = 0; i < desorden.length - 1; i++) {
            for (int j = i + 1; j < (desorden.length); j++) {
                if (desorden[i] > desorden[j]) {
                    menor = desorden[i];
                    desorden[i] = desorden[j];
                    desorden[j] = menor;
                }
            }
        }
        System.out.println(Arrays.toString(desorden));
    }   
}