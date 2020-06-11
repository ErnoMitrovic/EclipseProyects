import java.util.Scanner;
public class SegundaClase{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un número");
        int num = sc.nextInt();
        if (num > 0) System.out.println("Es un número positivo");
        else if (num == 0) System.out.println("El número es cero");
        else System.out.println("El número es negativo");
        sc.close();
    }
}