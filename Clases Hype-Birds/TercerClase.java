/*Dos constructores
Empleado, jefe
Puede compartir el jefe las caracterisitcas del empleado, pero el empleado no puede compartir las del jefe  
*/
/* 
Empleado: Tareas 
Salario
Nombre y apellido 
años de experiencia 
posicion
estatura
Jefe 
Horas extras
Extra de salario
 */
public class TercerClase{
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Recoger",3_000_000,"Carlos","Drogas",15, "Recolector", 1.9);
        Empleado jefe = new Empleado("Papi", "Grovas");
        System.out.println(empleado1.getTareas());
        System.out.println(jefe.getTareas());
    }
}
class Empleado {
    private String tareas;
    private double salario;
    private String nombre;
    private String apellido;
    private int añosDeExperiencia;
    private String posicion;
    private double estatura;
    private int horasExtra;
    private double extraDeSalario;
    public Empleado (String tareas, double salario, String nombre, String apellido, int añosDeExperiencia, String posicion, double estatura){
        this.tareas = tareas;
        this.salario = salario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.añosDeExperiencia = añosDeExperiencia;
        this.posicion = posicion;
        this.estatura = estatura;
    }
    public Empleado (String nombre, String apellido){
        this("Dar tareas", 2_000_000, nombre, apellido, 15, "Jefe", 2.5);
        horasExtra = 2;
        extraDeSalario = 300_000;
    }
    String getTareas(){
        return tareas;
    }
    double getSalario(){
        return salario;
    }
    String getApellido(){
        return apellido;
    }
    
}