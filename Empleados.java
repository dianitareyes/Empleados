import java.util.Scanner;
import java.util.HashSet;

public class Empleado {
    
    private int idEmpleado;
    private String nombreEmpleado;
    private String puesto;
    private double[] sueldoQuincenal = new double[2];

     private static HashSet<Integer> idsRegistrados = new HashSet<>();

    
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            System.out.print("Ingrese el ID del empleado (único y numérico): ");
            if (scanner.hasNextInt()) {
                idEmpleado = scanner.nextInt();
                if (!idsRegistrados.contains(idEmpleado)) {
                    idsRegistrados.add(idEmpleado);
                    break;
                } else {
                    System.out.println("Error: El ID ya está registrado.");
                }
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next(); 
            }
        } 
    }    

}
