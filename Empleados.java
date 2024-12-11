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

        scanner.nextLine(); 
        while (true) {
            System.out.print("Ingrese el nombre del empleado: ");
            nombreEmpleado = scanner.nextLine();
            if (!nombreEmpleado.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Error: El nombre no puede estar vacío.");
            }
        } 

        while (true) {
            System.out.print("Ingrese el puesto (Empleado o Supervisor): ");
            puesto = scanner.nextLine();
            if (puesto.equalsIgnoreCase("Empleado") || puesto.equalsIgnoreCase("Supervisor")) {
                break;
            } else {
                System.out.println("Error: El puesto debe ser 'Empleado' o 'Supervisor'.");
            }
        }
    }  
     public void calcularSueldo() {
        Scanner scanner = new Scanner(System.in);

        if (puesto.equalsIgnoreCase("Empleado")) {
            double sueldoBase = 5000;

            
            int horasExtrasDiurnas = 0, horasExtrasNocturnas = 0;
            while (true) {
                try {
                    System.out.print("Ingrese las horas extras diurnas trabajadas: ");
                    horasExtrasDiurnas = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ingrese las horas extras nocturnas trabajadas: ");
                    horasExtrasNocturnas = Integer.parseInt(scanner.nextLine());
                    if (horasExtrasDiurnas >= 0 && horasExtrasNocturnas >= 0) {
                        break;
                    } else {
                        System.out.println("Error: Las horas extras no pueden ser negativas.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }

        }
     }          

}
