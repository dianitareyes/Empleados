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

            double pagoHorasExtras = (horasExtrasDiurnas * 50) + (horasExtrasNocturnas * 60);
            sueldoQuincenal[0] = sueldoBase + pagoHorasExtras;
            sueldoQuincenal[1] = sueldoBase; 

        } else if (puesto.equalsIgnoreCase("Supervisor")) {
            double sueldoBase = 8000;

            
            double deduccionInfonavit = sueldoBase * 0.002;
            double deduccionSeguro = sueldoBase * 0.001;
            double deduccionISR = sueldoBase * 0.016;

            double totalDeducciones = deduccionInfonavit + deduccionSeguro + deduccionISR;
            sueldoQuincenal[0] = sueldoBase - totalDeducciones; 
            sueldoQuincenal[1] = sueldoBase - totalDeducciones; 
        }

        
    }  

    public void mostrarInformacion() {
        System.out.println("\n--- Información del Empleado ---");
        System.out.println("ID: " + idEmpleado);
        System.out.println("Nombre: " + nombreEmpleado);
        System.out.println("Puesto: " + puesto);
        System.out.printf("Sueldo Primera Quincena: $%.2f\n", sueldoQuincenal[0]);
        System.out.printf("Sueldo Segunda Quincena: $%.2f\n", sueldoQuincenal[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            Empleado empleado = new Empleado();

            
            empleado.ingresarDatos();

           
            empleado.calcularSueldo();

            
            empleado.mostrarInformacion();

           
            System.out.print("\n¿Desea registrar otro empleado? (si/no): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("si");
        }

        System.out.println("Programa finalizado. ¡Gracias!");
    }
        

}
